package com.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)   // 排除数据源自动配置
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain.class, args);
    }
}
