package com.isspark.cloud.eurekaclientprovider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService{

    private static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String name) {
        log.info("test mdc:{}", MDC.get("helloId"));
        return String.format("hello,%s",name);
    }
}
