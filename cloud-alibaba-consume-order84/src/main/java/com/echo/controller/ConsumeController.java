package com.echo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.echo.entity.CommonResult;
import com.echo.entity.Payment;
import com.echo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public PaymentService paymentService;

    public static final String serviceUrl = "http://nacos-payment-provider";

    /*
     blockHandler处理 sentinel中配置出现的异常
     fallback处理程序中出现的异常
     exceptionsToIgnore:该类型的异常不会执行fallback的兜底方法
    */
    @GetMapping("/fallback/{id}")
//    @SentinelResource(value = "fallback", blockHandler = "fallBackHandler", fallback = "fallBackMethod",exceptionsToIgnore = {IllegalArgumentException.class})
    @SentinelResource(value = "fallback", blockHandler = "fallBackHandler", fallback = "fallBackMethod")

    public CommonResult<Payment> restTemFallback(@PathVariable("id") Long id) {
        // 测试异常
        CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSql/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException 空指针异常");
        }
        return result;
    }


    @GetMapping("/test")
    public String test() {
        return "hello" + "hahahha";
    }


    /*
    使用 feign 进行服务间的调用和负载均衡
    自己认为：不是sentinel配置的异常，运行时异常或者服务端 宕机的化兜底的fallback方法会执行feign中配置的fallback方法
     */

    @GetMapping("/consume/feignBack2/{id}")
    @SentinelResource(value = "feignFallback2", blockHandler = "feignFallback2")
    public CommonResult<Payment> feignFallback2(@PathVariable("id") Long id) {
        CommonResult<Payment> result = paymentService.getPayment(id);
        return result;
    }

    /*
    Sentinel中配置异常后的回调方法
     */
    public CommonResult<Payment> feignFallback2(Long id, BlockException blockException) {
        return new CommonResult<>(444, "feign 结合sentinel blockexception的方法", null);
    }

    @GetMapping("/consume/feignBack/{id}")
    public CommonResult<Payment> feignFallback(@PathVariable("id") Long id) {

        CommonResult<Payment> result = paymentService.getPayment(id);

        return result;
    }

    public CommonResult<Payment> fallBackHandler(Long id, BlockException blockException) {
        return new CommonResult<Payment>(444, "blockException", null);
    }

    public CommonResult<Payment> fallBackMethod(Long id) {
        return new CommonResult<Payment>(444, "fallBackMethod", null);
    }


}
