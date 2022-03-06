package com.echo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.echo.entity.CommonResult;
import com.echo.entity.Payment;

public class RateLimitConfig {
    /*
    定义一个全局的 限流后 兜底的方法
    注意这个限流的兜底方法中的参数要有BlockException
     */
    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(444, "全局handlerexception方法", new Payment(1L, "handler1"));
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(444, "全局handlerexception方法", new Payment(2L, "handler2"));
    }
}
