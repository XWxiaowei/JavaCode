package com.jay.thread.chap04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/22
 */
@RunWith(JUnit4.class)
public class VisualComponentTest {
    private final ExecutorService exec = Executors.newFixedThreadPool(100);
    final VisualComponent visualComponent = new VisualComponent();
    @Test
    public void addKeyListener() throws Exception {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    visualComponent.addKeyListener("key"+String.valueOf(finalI));
                }
            });
        }
    }

    @Test
    public void addMouseListener() throws Exception {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    visualComponent.addMouseListener(finalI);
                }
            });
        }
    }

    @Test
    public void removeKeyListener() throws Exception {
    }

    @Test
    public void removeMouseListener() throws Exception {
    }

}