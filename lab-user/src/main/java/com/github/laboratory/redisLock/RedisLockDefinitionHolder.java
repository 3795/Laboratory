package com.github.laboratory.redisLock;

import lombok.Data;

/**
 * 任务队列保存参数
 */
@Data
public class RedisLockDefinitionHolder {

    // 业务唯一Key
    private String businessKey;

    // 加锁时间（单位：秒）
    private Long lockTime;

    // 上次更新时间
    private Long lastModifyTime;

    // 保存当前线程
    private Thread currentThread;

    // 总共允许的续时次数
    private int tryCount;

    // 当前尝试的续时次数
    private int currentCount;

    // 更新锁的时间周期，防止业务时间过长导致锁过期，值 = 加锁时间 / 3
    private Long modifyPeriod;

    public RedisLockDefinitionHolder(String businessKey, Long lockTime, Long lastModifyTime, Thread currentThread, int tryCount) {
        this.businessKey = businessKey;
        this.lockTime = lockTime;
        this.lastModifyTime = lastModifyTime;
        this.currentThread = currentThread;
        this.tryCount = tryCount;
        this.currentCount = 0;
        this.modifyPeriod = lockTime * 1000 / 3;
    }
}
