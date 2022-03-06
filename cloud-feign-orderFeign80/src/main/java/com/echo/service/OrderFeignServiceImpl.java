package com.echo.service;

import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface OrderFeignServiceImpl {

    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
