package com.echo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class HystrixPayment {
    // 服务的降级 fallback
    public String paymentInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "payment_ok" + id + "哈哈哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            //Thread.sleep(3000);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /// int a=10/0;
        return "线程池" + Thread.currentThread().getName() + "payment_ok" + id + "哈哈哈哈";
    }

    @HystrixCommand(fallbackMethod = "handlers", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOuts() {
        try {
            //Thread.sleep(3000);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /// int a=10/0;
        return "线程池" + Thread.currentThread().getName() + "payment_ok" + "哈哈哈哈";
    }

    // 这个返回函数的参数个数 要和 原来函数的参数个数和对象类型相同
    public String paymentInfo_timeOutHandler(Integer id) {
        return " i am  timeoutHandler";
    }

    public String handlers() {
        return " i am  handlers";
    }

    /*
    服务熔断
     */
    //   @HystrixProperty 的name的值 都在    HystrixPropertiesManager 这个类中
    @HystrixCommand(fallbackMethod = "cycileBreakerFallbacker", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 在某一时间段内的请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 在10s内请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到 60后开启 熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 小于0");
        }
        UUID uuid = UUID.randomUUID();
        return "服务请求正常" + uuid;
    }

    public String cycileBreakerFallbacker(Integer id) {
        return " i am  cyclie breaker fallback" + id;
    }
}
