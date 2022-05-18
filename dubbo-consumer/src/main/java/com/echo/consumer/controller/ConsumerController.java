package com.echo.consumer.controller;

import com.echo.dao.ProviderTestDTO;
import com.echo.service.IProviderService;
import com.echo.vo.ResultVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumerController {
    /**
     * Dubbo远程调用的注解
     * timeout 设置这个接口 的超时时间 ， 配置的加载顺序 参考dubbo的官网来看
     * retries 设置 超时后重试的次数 ，不包括第一次调用的次数
     */

//    @Reference(timeout = 6000)
    @Reference(timeout = 4000, retries = 3, loadbalance = "roundrobin")
    private IProviderService iProviderService;

    @HystrixCommand(fallbackMethod = "providerRollback")
    @GetMapping("/getList")
    public ResultVO getList() {
        List<ProviderTestDTO> list = iProviderService.queryList();
        return new ResultVO().toBuilder().data(list).code(200).message("success").build();

}

    public ResultVO providerRollback() {
        return new ResultVO().toBuilder().data(null).code(899).message("failure").build();
    }

    @GetMapping("test")
    public String test1() {
        return "hello";
    }
}
