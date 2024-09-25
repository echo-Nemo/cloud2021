package com.echo.service;

import com.echo.anotation.PrintMethodAnotationTest;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    /**
     * 对 @PrintMethodAnotation  注解 对addMoney方法增强
     *
     * @param money
     */
    @PrintMethodAnotationTest
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }


    public static void main(String[] args) {
        FinanceService financeService = new FinanceService();
        financeService.addMoney(800000d);
    }
}
