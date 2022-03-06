package com.rule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Myrules {
    @Bean
    public IRule myRule() {
        return new WeightedResponseTimeRule();
    }
}
