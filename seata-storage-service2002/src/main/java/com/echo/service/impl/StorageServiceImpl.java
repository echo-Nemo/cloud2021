package com.echo.service.impl;

import com.echo.dao.StorageDao;
import com.echo.domain.CommonResult;
import com.echo.domain.Storage;
import com.echo.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /*
    展示出现异常后，order服务调用该服务接口时，是否会回滚
     */
    @Override
    public void storageDecrease(Long productId, Integer count) {
       // int a = 10 / 0;
        storageDao.storageDecrease(productId, count);
    }
}
