package com.github.laboratory.readWrite.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 决定系统使用哪个数据源
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // 返回当前线程正在设置的数据源
        return DynamicSwitchDbTypeUtil.get();
    }
}
