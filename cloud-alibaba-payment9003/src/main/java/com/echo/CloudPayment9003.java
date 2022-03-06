package com.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudPayment9003.class, args);
    }
}
