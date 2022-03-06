package com.echo.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFeignHystrixService implements OrderService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return " i ma  ok fallback method";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "i am timeout fallback method";
    }

    @Override
    public String paymentInfo_TimeOutHandler() {
        return "i am timeout handler fallbalck method";
    }
}
