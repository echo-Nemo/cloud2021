package com.echo.service;

import com.echo.domain.CommonResult;
import com.echo.domain.Storage;
import org.apache.ibatis.annotations.Param;

public interface StorageService {
    public void storageDecrease(Long productId, Integer count);
}
