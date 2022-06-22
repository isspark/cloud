package com.isspark.eureka.eurekaserver.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaEventListener {

    private static Logger log = LoggerFactory.getLogger(EurekaEventListener.class);

    @EventListener
    public void eurekaRegistryAvaliable(EurekaRegistryAvailableEvent  event){
        log.info("eureka registry available , send email !");
    }
}
