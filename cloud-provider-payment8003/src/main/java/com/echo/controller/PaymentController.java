package com.echo.controller;


import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import com.echo.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/paymetn/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult<>(200, "新增成功", payment);
        } else {
            return new CommonResult<>(4444, "插入失败", null);
        }
    }


    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功" + port, payment);
        } else {
            return new CommonResult<>(444, "查询失败" + port, null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping(value = "/payment/testSleuth")
    public String paymentTestSleuth() {
        return " i am 8003 payment/testSleuth";
    }
}
