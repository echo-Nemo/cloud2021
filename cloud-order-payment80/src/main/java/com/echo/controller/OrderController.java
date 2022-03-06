package com.echo.controller;

import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    // private  static final  String url="http://localhost:8002";
    private static final String url = "http://cloud-payment-service";

    @GetMapping("/consume/oder/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.debug(url);
        return restTemplate.getForObject(url + "/payment/findById/" + id, CommonResult.class);
    }

    @GetMapping("/consume/create")
    public CommonResult<Payment> createPayment(Payment payment) {
        return restTemplate.postForObject(url + "/paymetn/create", payment, CommonResult.class);

    }

    @GetMapping("/consume/oder/getPaymentByEntity/{id}")
    public CommonResult<Payment> getPaymentByEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(url + "/payment/findById/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<Payment>(444, "失败了", null);
        }
    }


    @GetMapping(value = "/consume/testSleuth")
    public String paymentTestSleuth() {
        return restTemplate.getForObject(url + "/payment/testSleuth", String.class);
    }


}
