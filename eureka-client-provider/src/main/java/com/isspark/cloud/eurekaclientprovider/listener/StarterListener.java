package com.isspark.cloud.eurekaclientprovider.listener;

import com.isspark.starter.event.EventListener;
import com.isspark.starter.event.StarterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StarterListener implements EventListener<StarterEvent> {

    private Logger logger = LoggerFactory.getLogger(StarterListener.class);

    @Override
    public void onEvent(StarterEvent event) {
        logger.info("process starter listener");
    }
}
