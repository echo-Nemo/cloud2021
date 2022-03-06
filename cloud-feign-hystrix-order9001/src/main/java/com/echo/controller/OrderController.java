package com.echo.controller;


import com.echo.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.P11Util;

@RestController
@DefaultProperties(defaultFallback = "globalFallback_method")  // 指定全局的fallback方法
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id")Integer id) {
        return orderService.paymentInfo_Ok(id);

    }


//    @GetMapping("/payment/hystrix/TimeOut/{id}")
////    @HystrixCommand(fallbackMethod = "fallback_method", commandProperties = {@HystrixProperty
////            (name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
////    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
////        return orderService.paymentInfo_TimeOut(id);
////    }

    @GetMapping("/payment/hystrix/TimeOuts")
//    @HystrixCommand(fallbackMethod = "fallback_method", commandProperties = {@HystrixProperty
//            (name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    @HystrixCommand
    public String paymentInfo_TimeOut() {
        return orderService.paymentInfo_TimeOutHandler();
    }


    public String fallback_method() {
        return "i am fallback method 80";
    }

    // 指定全局的 fallback方法，如果其它方法没有特别指定 fallback方法，默认会调用 该fallback方法
    public String globalFallback_method() {
        return "i am global fallback method";
    }

}
