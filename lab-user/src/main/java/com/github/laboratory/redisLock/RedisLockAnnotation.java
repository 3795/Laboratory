package com.github.laboratory.redisLock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RedisLockAnnotation {

    // 特定参数标识，，默认取第0个下标
    int lockField() default 0;

    // 超时重试次数
    int tryCount() default 3;

    // 自定义加锁类型
    RedisLockTypeEnum typeEnum();

    // 加锁时间，默认30秒
    long lockTime() default 30;

}
