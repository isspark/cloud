package com.isspark.starter.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleEventMulticaster implements EventMulticaster{

    private Map<Class<?>, List<EventListener>> listenerMap = new ConcurrentHashMap<>();

    @Override
    public void multicastEvent(AbstractEvent event) {
        List<EventListener> listeners = listenerMap.get(event.getClass());
        if(listeners != null){
            for (EventListener listener : listeners){
                listener.onEvent(event);
            }
        }

    }

    @Override
    public void addEventListener(EventListener<?> listener) {
        Class<?> eventType = getEventType(listener);
        List<EventListener> listeners = listenerMap.get(eventType);
        if(listeners == null){
            listeners = new ArrayList<>();
            listenerMap.put(eventType,listeners);
        }
        listeners.add(listener);

    }

    @Override
    public void removeEventListener(EventListener<?> listener) {
        Class<?> eventType = getEventType(listener);
        List<EventListener> listeners = listenerMap.get(eventType);
        if(listeners != null){
            listeners.remove(listener);
        }
    }

    protected Class<?> getEventType(EventListener listener){
        ParameterizedType parameterizedType = (ParameterizedType) listener.getClass().getGenericInterfaces()[0];
        Type eventType = parameterizedType.getActualTypeArguments()[0];
        return (Class<?>) eventType;
    }
}
