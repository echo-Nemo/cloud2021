package com.echo.service;

import com.echo.dao.PaymentDao;
import com.echo.entity.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPayment(long id) {
        return paymentDao.getPayment(id);
    }
}
