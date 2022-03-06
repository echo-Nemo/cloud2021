package com.echo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    public void accountDescrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
