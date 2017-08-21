package com.jay.thread.chap03;

/**
 * Created by xiang.wei on 2017/8/18.
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event event) {
                doSomething(event);
            }
        });
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
