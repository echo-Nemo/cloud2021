package com.echo.provider.service;

import com.echo.dao.ProviderTestDTO;
import com.echo.service.IProviderService;
import org.apache.dubbo.config.annotation.Service;


import java.util.ArrayList;
import java.util.List;

@Service        //  这里的service 是dubbo包下的 注解
public class ProviderServiceImpl implements IProviderService {
    public List<ProviderTestDTO> queryList() {
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
        return list;
    }
}
