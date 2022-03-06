package com.echo.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private Long userId; // 购买商品的用户的id
    private Long productId; // 商品id
    private Integer count; // 商品的数量
    private BigDecimal money; // 单件商品的价格
    private Integer status; // 订单状态 0创建中  1 已创建
}
