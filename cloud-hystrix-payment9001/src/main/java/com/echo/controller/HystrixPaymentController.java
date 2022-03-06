package com.echo.controller;


import com.echo.service.HystrixPayment;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixPaymentController {

    @Resource
    private HystrixPayment hystrixPayment;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        return hystrixPayment.paymentInfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return hystrixPayment.paymentInfo_TimeOut(id);
    }

    @GetMapping("/payment/hystrix/timeOutHandler")
    public String paymentInfo_TimeOutHandler() {
        return hystrixPayment.paymentInfo_TimeOuts();
    }


    @GetMapping("/payment/circuit/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return hystrixPayment.paymentCircuitBreaker(id);
    }


}
