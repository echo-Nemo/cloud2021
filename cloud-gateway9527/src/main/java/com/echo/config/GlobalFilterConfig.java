package com.echo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilterConfig implements GlobalFilter, Ordered {
    // 在请求时只有带有用户名和密码才能对服务进行访问

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // getFirst 表示请求路径中 第一个参数名称为 userName
        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (StringUtils.isNotBlank(userName)) {
            return chain.filter(exchange);
        }
        log.info("请带有username再进行访问");
        exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
