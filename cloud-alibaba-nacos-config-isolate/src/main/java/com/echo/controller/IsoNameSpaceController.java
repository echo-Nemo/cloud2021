package com.echo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class IsoNameSpaceController {

    @Value("${current.env}")
    private String currentEnv;

    @GetMapping("/get/env")
    public String getCurrentEnv() {
        return currentEnv;
    }

}
