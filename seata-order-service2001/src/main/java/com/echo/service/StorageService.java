package com.echo.service;

import com.echo.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageService {
    // 某个商品的个数
    @PostMapping("/storage/decrease")
    public void storageDesc(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
