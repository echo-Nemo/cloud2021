package com.echo.service;

import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 指定在调用过程中服务降级的方法 PaymentFallbackService
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
