package com.isspark.starter.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarterListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(StarterListener.class);

    @Override
    public void onEvent(AbstractEvent event) {
        logger.info("process starter listener");
    }
}
