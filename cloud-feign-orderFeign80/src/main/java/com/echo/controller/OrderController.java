package com.echo.controller;


import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import com.echo.service.OrderFeignServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderFeignServiceImpl orderFeignService;

    @GetMapping("/consume/oder/getPayment/{id}")
    public CommonResult<Payment> getOrderPayment(@PathVariable("id") Long id) {
        return orderFeignService.findById(id);
    }

    @GetMapping(value = "/consume/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return orderFeignService.paymentFeignTimeout();
    }
}
