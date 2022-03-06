package com.echo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
// @FeignClient(value = "cloud-provider-hystrix-payment")
// 如果在调用过程中出现服务端出现宕机问题，指定fallback方法   在yml配置文件中 开启 feign-hystrix-enabled =true
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = OrderFeignHystrixService.class)
public interface OrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok( @PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut( @PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/TimeOutHandler")
    public String paymentInfo_TimeOutHandler();

}
