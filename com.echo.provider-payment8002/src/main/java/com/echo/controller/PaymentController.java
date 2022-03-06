package com.echo.controller;


import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import com.echo.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/paymetn/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult<>(200, "新增成功", payment);
        } else {
            return new CommonResult<>(4444, "插入失败", null);
        }
    }


    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功hhahah" + port, payment);
        } else {
            return new CommonResult<>(444, "查询失败hhahah" + port, null);
        }
    }

    @GetMapping("/payment/getInstance")
    private Object getInstanceIndo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return port;
    }

}
