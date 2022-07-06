package com.isspark.starter;

import com.isspark.starter.event.EventListener;
import com.isspark.starter.event.EventMulticaster;
import com.isspark.starter.event.SimpleEventMulticaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MulticasterAutoConfiguration {

    @Autowired(required = false)
    private List<EventListener> eventListeners;

    @Bean
    public EventMulticaster eventMulticaster(){
        EventMulticaster multicaster = new SimpleEventMulticaster();
        if(eventListeners != null){
            eventListeners.forEach(multicaster::addEventListener);
        }
        return multicaster;
    }
}
