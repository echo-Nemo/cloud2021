package com.echo.controller;

import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class CloudPaymentController {
    @Value("${server.port}")
    public String port;

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("port" + port);
        Payment mapInstant = getMapInstant(id);
        return new CommonResult<Payment>(200, "success" + port, mapInstant);
    }

    public static Payment getMapInstant(Long id) {
        HashMap<Long, Payment> map = new HashMap<>();
        map.put(1L, new Payment(1L, "serila-01"));
        map.put(2L, new Payment(2L, "serila-02"));
        map.put(3L, new Payment(3L, "serila-03"));
        return map.get(id);
    }
}
