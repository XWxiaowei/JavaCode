package com.jay.thread.chap03;


/**
 * Created by xiang.wei on 2017/8/18.
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event event){
                doSomething(event);
            }
        };
    }
    public static SafeListener newInstance(EventSource source){
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e){

    }

    interface EventListener {
        void onEvent(Event event);
    }

    interface Event {

    }
    interface EventSource{
        void registerListener(EventListener e);
    }

}
