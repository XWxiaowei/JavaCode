package com.jay.thread.chap02;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模拟多线程访问
 * Created by xiang.wei on 2017/8/17.
 */
@RunWith(JUnit4.class)
public class UnsafeCountingFactorizerTest {
    ExecutorService exec = Executors.newFixedThreadPool(100);
    UnsafeCountingFactorizer countingFactorizer = new UnsafeCountingFactorizer();

    ServletRequest req;
    ServletResponse res;
    @Before
    public void setUp(){
        req = PowerMockito.mock(ServletRequest.class);
        res = PowerMockito.mock(ServletResponse.class);
    }
    @Test
    public void testService() throws Exception {
        for (int i=0;i<100;i++){
            exec.submit(new Runnable() {
                public void run() {
                    countingFactorizer.service(req,res);
                    System.out.println(Thread.currentThread().getName()+"/"+countingFactorizer.getCount());
                }
            });
            exec.submit(new Runnable() {
                public void run() {
                    countingFactorizer.service(req,res);
                    System.out.println(Thread.currentThread().getName()+"/"+countingFactorizer.getCount());
                }
            });
        }
        System.out.println(Thread.currentThread().getName()+"/"+countingFactorizer.getCount());

    }
}