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
 * Created by xiang.wei on 2017/8/17.
 */
@RunWith(JUnit4.class)
public class CountingFactorizerTest {
    ExecutorService exec = Executors.newFixedThreadPool(100);
    CountingFactorizer countingFactorizer = new CountingFactorizer();

    ServletRequest req;
    ServletResponse res;
    @Before
    public void setUp(){
        req = PowerMockito.mock(ServletRequest.class);
        res = PowerMockito.mock(ServletResponse.class);
    }
    @Test
    public void testGetCount() throws Exception {
       for (int i=0;i<10;i++){
           exec.submit(new Runnable() {
               public void run() {
                   System.out.println(Thread.currentThread().getName()+"/"+countingFactorizer.getCount());
               }
           });
       }
    }

    @Test
    public void testService() throws Exception {
        for (int i=0;i<10;i++){
            exec.submit(new Runnable() {
                public void run() {
                    countingFactorizer.service(req,res);
                    System.out.println(Thread.currentThread().getName()+"/"+countingFactorizer.getCount());
                }
            });
        }
    }
}