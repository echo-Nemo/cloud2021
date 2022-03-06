package com.echo.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountService {
    public void accountDescrease(Long userId, BigDecimal money);
}
