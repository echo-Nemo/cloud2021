package com.echo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig3399 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3399.class, args);
    }
}
