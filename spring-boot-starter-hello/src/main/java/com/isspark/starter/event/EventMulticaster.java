package com.isspark.starter.event;

public interface EventMulticaster {

    void multicastEvent(AbstractEvent event);

    void addEventListener(EventListener<?> listener);

    void removeEventListener(EventListener<?> listener);
}
