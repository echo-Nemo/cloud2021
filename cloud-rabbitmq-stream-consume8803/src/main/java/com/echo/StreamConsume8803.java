package com.echo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamConsume8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsume8803.class,args);

    }
}
