package com.github.laboratory.readWrite.config;

import lombok.extern.slf4j.Slf4j;

/**
 * 动态切换数据库类型的工具
 */
@Slf4j
public class DynamicSwitchDbTypeUtil {

    /**
     * 存储代表数据源的对象，存储的是MASTER，使用的是主库，存储的是SLAVE，使用的是从库
     */
    private static final ThreadLocal<DbTypeEnum> CONTEXT_HEAD = new ThreadLocal<>();

    /**
     * 设置当前线程需要使用的数据源
     *
     * @param dbTypeEnum
     */
    public static void set(DbTypeEnum dbTypeEnum) {
        CONTEXT_HEAD.set(dbTypeEnum);
        log.info("切换数据源：{}", dbTypeEnum);
    }

    /**
     * 切换到Master库
     */
    public static void master() {
        set(DbTypeEnum.MASTER);
    }

    /**
     * 切换到Slave库
     * 暂时只有一个从库，所以直接设置就行了
     * 如果我们有多个从库，那么需要一种轮询算法去访问不同的从库
     */
    public static void slave() {
        set(DbTypeEnum.SLAVE);
    }

    /**
     * 移除当前线程使用的数据源
     * 另一个是为了防止ThreadLocal内存泄露
     */
    public static void remove() {
        CONTEXT_HEAD.remove();
    }

    public static DbTypeEnum get() {
        return CONTEXT_HEAD.get();
    }
}
