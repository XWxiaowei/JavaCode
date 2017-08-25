package com.jay.thread.chap06;

import java.util.Timer;
import java.util.TimerTask;
import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * https://my.oschina.net/lujianing/blog/705894
 * 模拟Timer的糟糕行为
 * Created by xiang.wei on 2017/8/24
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }

}
