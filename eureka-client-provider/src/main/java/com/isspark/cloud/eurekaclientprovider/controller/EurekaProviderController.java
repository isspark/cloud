package com.isspark.cloud.eurekaclientprovider.controller;

import com.isspark.cloud.eurekaclientprovider.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/eureka")
public class EurekaProviderController {

    private static Logger log = LoggerFactory.getLogger(EurekaProviderController.class);

    @Autowired
    private IHelloService helloService;

    @GetMapping("/hello")
    public String hello(@RequestParam("name")String name){
        MDC.put("helloId", UUID.randomUUID().toString());
        log.info("test mdc:{}",MDC.get("helloId"));
        return helloService.sayHello(name);
    }
}
