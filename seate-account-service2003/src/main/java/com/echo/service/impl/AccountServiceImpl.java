package com.echo.service.impl;

import com.echo.dao.AccountDao;
import com.echo.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void accountDescrease(Long userId, BigDecimal money) {
        accountDao.accountDescrease(userId, money);
    }
}
