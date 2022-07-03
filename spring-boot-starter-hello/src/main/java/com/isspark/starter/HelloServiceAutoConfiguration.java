package com.isspark.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.isspark.starter.config.HelloStarterConfig;
import com.isspark.starter.service.HelloStarterService;

@Configuration
@EnableConfigurationProperties(HelloStarterConfig.class)
@ConditionalOnClass(HelloStarterService.class)
@ConditionalOnProperty(prefix = "hello", name = "enabled", matchIfMissing = false)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloStarterConfig helloStarterConfig;

    @Bean
    @ConditionalOnMissingBean(HelloStarterService.class)
    public HelloStarterService helloStarterService(){
        HelloStarterService starterService = new HelloStarterService();
        starterService.setName(helloStarterConfig.getName());
        return starterService;
    }
}
