package com.echo.service;

import com.echo.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public  int  create(Payment payment);

    public Payment getPayment(@Param("id") long id);
}
