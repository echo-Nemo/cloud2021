package com.echo.controller;

import com.echo.domain.CommonResult;
import com.echo.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

//    @PostMapping("/account/decrease")
//    public CommonResult accountDecrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
//        accountService.accountDescrease(userId, money);
//        return new CommonResult(200, null, "success");
//    }

    @PostMapping("/account/decrease")
    public void accountDecrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.accountDescrease(userId, money);
    }

}
