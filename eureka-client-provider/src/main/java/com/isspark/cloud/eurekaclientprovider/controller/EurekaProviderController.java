package com.isspark.cloud.eurekaclientprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eureka")
public class EurekaProviderController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name")String name){
        return "";
    }
}