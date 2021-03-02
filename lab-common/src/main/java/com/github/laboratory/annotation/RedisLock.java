package com.github.laboratory.annotation;

import com.github.laboratory.enums.RedisLockTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 3795
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RedisLock {

    // 特定参数标识，默认取第0个下标
    int lockField() default 0;

    // 超时重试次数
    int tryCount() default 3;

    // 自定义加锁类型
    RedisLockTypeEnum typeEnum();

    // 加锁时间，默认30秒
    long lockTime() default 30;

}
