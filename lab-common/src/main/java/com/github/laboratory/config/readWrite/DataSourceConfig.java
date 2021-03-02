package com.github.laboratory.config.readWrite;

import com.github.laboratory.enums.DbTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    /**
     * 将master数据源放入spring容器中
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 将slave数据源放入spring容器中
     *
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 决定最终使用的数据源
     *
     * @return
     */
    @Bean
    public DataSource targetDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                       @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        // 放入master源
        targetDataSource.put(DbTypeEnum.MASTER, masterDataSource);
        // 放入slave源
        targetDataSource.put(DbTypeEnum.SLAVE, slaveDataSource);

        RoutingDataSource routingDataSource = new RoutingDataSource();
        // 绑定所有数据源
        routingDataSource.setTargetDataSources(targetDataSource);
        // 设置默认数据源
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        return routingDataSource;
    }
}
