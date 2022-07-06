package com.isspark.cloud.eurekaclientprovider.controller;

import com.isspark.cloud.eurekaclientprovider.config.ReadConfigToJava;
import com.isspark.cloud.eurekaclientprovider.service.IHelloService;
import com.isspark.starter.event.EventMulticaster;
import com.isspark.starter.event.StarterEvent;
import com.isspark.cloud.eurekaclientprovider.listener.StarterListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.isspark.starter.service.HelloStarterService;

import java.util.UUID;

@RestController
@RequestMapping("/eureka")
public class EurekaProviderController {

    private static Logger log = LoggerFactory.getLogger(EurekaProviderController.class);

    @Autowired
    private IHelloService helloService;

    @Autowired
    private ReadConfigToJava config;

    @Autowired(required = false)
    private HelloStarterService helloStarterService;

    @Autowired
    private EventMulticaster eventMulticaster;

    @GetMapping("/hello")
    public String hello(@RequestParam("name")String name){
        MDC.put("helloId", UUID.randomUUID().toString());
        log.info("test mdc:{}",MDC.get("helloId"));
        return helloService.sayHello(name);
    }

    @GetMapping("/config")
    public String config(){
        return config.getName();
    }

    @GetMapping("/starter")
    public String starter(){
        return helloStarterService.sayHelloStarter();
    }

    @GetMapping("/event")
    public String event(@RequestParam("name") String name){
        log.info("publish starter event");
        eventMulticaster.multicastEvent(new StarterEvent(this,name));
        return "SUCCESS";
    }
}
