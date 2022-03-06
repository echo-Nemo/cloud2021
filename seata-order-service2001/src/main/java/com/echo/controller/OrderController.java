package com.echo.controller;

import com.echo.domain.CommonResult;
import com.echo.domain.Order;
import com.echo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    public OrderService orderService;

    /*
    get接口用于用户前端做请求
     */
    @GetMapping("/order/create")
    public CommonResult<Order> createOrder(Order order) {
        orderService.create(order);
        return new CommonResult<Order>(200, null, "success");
    }
}
