package com.echo.controller;

import com.echo.domain.CommonResult;
import com.echo.domain.Storage;
import com.echo.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

//    @PostMapping("/storage/decrease")
//    public CommonResult storageDesc(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
//        storageService.storageDecrease(productId, count);
//        return new CommonResult(200, null, "success");
//    }

    @PostMapping("/storage/decrease")
    public void storageDesc(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.storageDecrease(productId, count);
    }
}
