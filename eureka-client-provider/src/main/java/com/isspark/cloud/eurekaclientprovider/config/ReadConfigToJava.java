package com.isspark.cloud.eurekaclientprovider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "prop")
public class ReadConfigToJava {

    private String name;

    public ReadConfigToJava() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
