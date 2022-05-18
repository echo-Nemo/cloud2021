package com.echo.provider.service;

import com.echo.dao.ProviderTestDTO;
import com.echo.service.IProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service        // 暴露服务的接口  这里的service 是dubbo包下的 注解
public class ProviderServiceImpl implements IProviderService {
    @HystrixCommand
    public List<ProviderTestDTO> queryList() {
        System.out.println("我是provider service");
        List<ProviderTestDTO> list = new ArrayList<ProviderTestDTO>();

        ProviderTestDTO testDTO = new ProviderTestDTO();
        testDTO.setId(1);
        testDTO.setName("sansan");
        testDTO.setNumber(101);

        ProviderTestDTO testDTO2 = new ProviderTestDTO();
        testDTO2.setId(2);
        testDTO2.setName("sisi");
        testDTO2.setNumber(102);

        list.add(testDTO);
        list.add(testDTO2);
        // 这里模仿 超时 时间  接口默认调用的时间是 1000 ms  也可以直接在配置文件 中 定义 超时时间
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 模拟服务降级的处理
        if (Math.random() > 0.1) {
            throw new RuntimeException();
        }
        return list;
    }
}
