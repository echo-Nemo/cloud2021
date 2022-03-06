package com.echo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope           // @RefreshScope 可以实现动态刷新  但是服务端每次修改后，客户端 只能 重启服务才能得到最新的配置
@RestController
public class ConfigController {
    @Value("${config.info}")    // config.profile 时服务器github 对应环境yml文件下的的内容
    private String configProfile;

    @GetMapping("/configInfo")
    public String getConfig() {
        return configProfile;
    }
}
