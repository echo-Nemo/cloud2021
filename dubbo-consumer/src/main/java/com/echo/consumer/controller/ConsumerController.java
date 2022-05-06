package com.echo.consumer.controller;

import com.echo.dao.ProviderTestDTO;
import com.echo.service.IProviderService;
import com.echo.vo.ResultVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumerController {
    // Dubbo远程调用的注解
    @Reference
    private IProviderService iProviderService;

    @GetMapping("/getList")
    public ResultVO getList() {
        List<ProviderTestDTO> list = iProviderService.queryList();
        return new ResultVO().toBuilder().data(list).code(200).message("success").build();

    }

    @GetMapping("test")
    public String test1(){
        return "hello";
    }
}
