package com.echo.service;

import com.echo.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-service")
public interface AccountService {
    @PostMapping("/account/decrease")
    public void accountDecrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
