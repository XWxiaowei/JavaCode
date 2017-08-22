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
public class ListHelperTest {
    private final ExecutorService exec = Executors.newFixedThreadPool(100);

    @Test
    public void putIfAbsent() throws Exception {
        BadListHelper<Integer> badListHelper = new BadListHelper<>();
        for (int i = 0; i <2 ; i++) {
            int finalI = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    Integer myInt = new Integer(finalI);
                    badListHelper.putIfAbsent(myInt);
                }
            });
            int finalI1 = i;
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    Integer myInt = new Integer(finalI1);
                    badListHelper.putIfAbsent(myInt);
                }
            });
        }

    }



}