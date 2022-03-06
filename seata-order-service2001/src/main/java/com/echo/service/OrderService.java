package com.echo.service;

import com.echo.domain.Order;

public interface OrderService {
    // 新增订单
    public void create(Order order);

    // 更新订单的操作 status
    public void update(Long userId, Integer status);
}
