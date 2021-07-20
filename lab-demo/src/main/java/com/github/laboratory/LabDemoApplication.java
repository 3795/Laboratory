package com.github.laboratory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 启动类
 * Created At 2021/7/20
 */
@SpringBootApplication
@MapperScan(value = "com.github.laboratory.mapper")
public class LabDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LabDemoApplication.class, args);
    }
}
