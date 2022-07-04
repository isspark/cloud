package com.isspark.starter.event;

public interface EventListener <E extends AbstractEvent>{

    void onEvent(E event);
}
