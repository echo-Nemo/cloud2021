package com.echo.dao;

import com.echo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public  int  create(Payment payment);

    public Payment getPayment(@Param("id") long id);


}
