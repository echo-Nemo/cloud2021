package com.echo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import com.echo.handler.RateLimitConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    /*
    通过url进行限流，出现异常 会使用sentinel自带的方式进行限流
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "rateByUrl")
    public CommonResult rateByUrl() {
        return new CommonResult(222, "通过url进行限流", new Payment(1L, "serial-01"));
    }

    /*
    定义一个全局的兜底的方法
     */
    @GetMapping("/rateLimit/rateLimitGlobl")
    @SentinelResource(value = "rateLimitGlobl", blockHandlerClass = RateLimitConfig.class, blockHandler = "handlerException2")
    public CommonResult rateLimitGlobl() {
        return new CommonResult(200, "success", new Payment(1L, "success"));
    }
}
