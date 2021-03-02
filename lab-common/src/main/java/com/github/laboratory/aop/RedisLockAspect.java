package com.github.laboratory.aop;

import com.github.laboratory.annotation.RedisLock;
import com.github.laboratory.enums.RedisLockTypeEnum;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RedisLockAspect {

    /**
     * 线程池，维护keyAliveTime
     */
    private static final ScheduledExecutorService SCHEDULER = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("redisLock-schedule-pool").daemon(true).build());

    /**
     * 存储目前有效的key定义，使用一个FIFO队列
     */
    private static ConcurrentLinkedQueue<RedisLockDefinitionHolder> holderList = new ConcurrentLinkedQueue<>();

    @Autowired
    private RedisTemplate redisTemplate;

    // 初始化时就开启后台线程
    // 定时任务一定要考虑到，一次任务执行失败后，会后续任务的影响，因为可能直接把后续的任务直接卡死
//    {
//        SCHEDULER.scheduleAtFixedRate(() -> {
//            Iterator<RedisLockDefinitionHolder> iterator = holderList.iterator();
//            while (iterator.hasNext()) {
//                RedisLockDefinitionHolder holder = iterator.next();
//                if (holder == null) {
//                    iterator.remove();
//                    continue;
//                }
//
//                // 超时重试次数，超时给线程设定中断，应该是超过最多续时次数
//                if (holder.getCurrentCount() > holder.getTryCount()) {
//                    holder.getCurrentThread().interrupt();
//                    iterator.remove();
//                    continue;
//                }
//
//                // 判断key是否失效，无效的话进行移除
//                if (redisTemplate.opsForValue().get(holder.getBusinessKey()) == null) {
//                    iterator.remove();
//                    continue;
//                }
//
//                // 判断锁是否进入最后的1/3时间
//                long curTime = System.currentTimeMillis();
//                boolean shouldExtend = (holder.getLastModifyTime() + holder.getModifyPeriod()) <= curTime;
//                if (shouldExtend) {
//                    holder.setLastModifyTime(curTime);
//                    redisTemplate.expire(holder.getBusinessKey(), holder.getLockTime(), TimeUnit.SECONDS);
//                    System.out.println("businessKey : [" + holder.getBusinessKey() + "], try count : " + holder.getCurrentCount());
//                    // 尝试次数加1，为了避免一个业务死了，加锁时间又长，一直不释放锁（虽然到了过期时间，还是会释放锁，但这样处理会快一些）
//                    holder.setCurrentCount(holder.getCurrentCount() + 1);
//                }
//            }
//        }, 0, 2, TimeUnit.SECONDS);     // 间隔两秒执行一次
//    }

    /**
     * 拦截特定注解
     */
    @Pointcut(value = "@annotation(com.github.laboratory.annotation.RedisLock)")
    public void redisLockPC() {

    }

    /**
     * 进入切面阻塞的问题：
     * 现象：
     * 1. 谷歌内核的浏览器不同窗口发送的并发请求（请求的地址和参数必须完全一致）进入切面时会被阻塞
     * 2. 火狐浏览器不同窗口发送的并发请求就不会被阻塞
     *
     * 原因：暂时还不清楚原因
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "redisLockPC()")
    public Object Object(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入切面时间" + System.currentTimeMillis());
        // 解析参数
        Method method = resolveMethod(pjp);
        RedisLock annotation = method.getAnnotation(RedisLock.class);
        RedisLockTypeEnum typeEnum = annotation.typeEnum();
        Object[] params = pjp.getArgs();

        // 将第一个参数作为Unique Key
        String ukString = params[annotation.lockField()].toString();
        String businessKey = typeEnum.getUniqueKey(ukString);
        String uniqueValue = UUID.randomUUID().toString();

        Object result = null;
        // 加锁
        try {
            boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(businessKey, uniqueValue);
            if (!isSuccess) {
                throw new Exception("其他应用已上锁");
            }
            redisTemplate.expire(businessKey, annotation.lockTime(), TimeUnit.SECONDS);
            Thread currentThread = Thread.currentThread();

            // 将本次Task信息加入到延时队列中
            holderList.add(new RedisLockDefinitionHolder(businessKey, annotation.lockTime(),
                    System.currentTimeMillis(), currentThread, annotation.tryCount()));

            System.out.println("已加锁，businessKey = " + businessKey);

            System.out.println("开始执行业务时间" + System.currentTimeMillis());
            result = pjp.proceed();     // 执行业务
            // 这个地方进行线程中断，其实是有疑问的，上面那个proceed其实是一个阻塞的过程，在阻塞之后才进行判断
            // 就算中断了又能够怎样呢，没什么用啊，业务已经执行完了，后面的锁还是会释放，并无二致，又不是一个自旋的重试过程
            // 这个地方记录一下超时日志更贴切一些，能够清晰看到哪些任务执行超时了，方便排查和优化
            if (currentThread.isInterrupted()) {
                throw new InterruptedException("当前线程被中断");
            }
        } catch (Exception e) {
            System.out.println("ErrorMessage: " + e.getMessage());
        } finally {
            releaseValidKey(businessKey, Thread.currentThread());
        }
        return result;
    }

    /**
     * 获取指定类上的方法
     *
     * @param clazz          指定类
     * @param name           指定方法
     * @param parameterTypes 找到就返回Method，找不到就返回null
     * @return
     */
    public static Method getDeclaredMethodFor(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            // 没有的话，就从父类上去找
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethodFor(superClass, name, parameterTypes);
            }
            return null;
        }
    }

    /**
     * 找到要代理的方法
     *
     * @param pjp
     * @return
     */
    private Method resolveMethod(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Class<?> targetClass = pjp.getTarget().getClass();

        // 这个地方为什么不直接用signature.getMethod()来获取注解标注的方法呢
        Method method = getDeclaredMethodFor(targetClass, signature.getName(), signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("Cannot resolve target method: " + signature.getMethod().getName());
        }
        return method;
    }

    /**
     * 优雅的释放分布式锁，释放的锁必须是当前线程上的锁，避免错误释放
     *
     * @param businessKey
     * @param currentThread
     */
    private void releaseValidKey(String businessKey, Thread currentThread) {
        RedisLockDefinitionHolder redisLockDefinitionHolder = holderList.stream()
                .filter(h -> businessKey.equals(h.getBusinessKey()))
                .findFirst()
                .orElse(null);
        if (redisLockDefinitionHolder != null && redisLockDefinitionHolder.getCurrentThread().equals(currentThread)) {
            // 确保是当前线程上的锁
            redisTemplate.delete(businessKey);
            System.out.println("释放锁，businessKey = " + businessKey);
            holderList.remove(redisLockDefinitionHolder);
        }
    }
}
