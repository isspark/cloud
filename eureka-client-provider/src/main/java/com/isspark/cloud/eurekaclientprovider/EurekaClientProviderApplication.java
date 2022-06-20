package com.isspark.cloud.eurekaclientprovider;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.TimeZone;

@SpringBootApplication
//@EnableEurekaClient
public class EurekaClientProviderApplication {

    public static void main(String[] args) {
        MDC.put("TranceID",String.valueOf(Thread.currentThread().getId()));
        SpringApplication.run(EurekaClientProviderApplication.class, args);
    }

}
