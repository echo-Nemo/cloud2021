package com.echo.dao;

import com.echo.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    // 新增订单
    public void create(Order order);

    // 更新订单的操作 status
    public void update(@Param("userId") Long userId, @Param("status") Integer status);
}
