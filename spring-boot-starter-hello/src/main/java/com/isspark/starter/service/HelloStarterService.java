package com.isspark.starter.service;

public class HelloStarterService {

    private String name;

    public String sayHelloStarter(){
        return "hello com.isspark.starter: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
