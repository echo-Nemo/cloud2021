package com.echo.service;

import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<Payment>(505, "fallbackException", new Payment(id, "error-serial"));
    }
}
