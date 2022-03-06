package com.echo.domain;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total; // 账户总额度
    private BigDecimal used; // 已用额度
    private BigDecimal residue;//剩余额度
}
