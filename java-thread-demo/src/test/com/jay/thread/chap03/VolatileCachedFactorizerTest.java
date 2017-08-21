package com.jay.thread.chap03;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class VolatileCachedFactorizerTest {
    final com.jay.thread.chap03.VolatileCachedFactorizer volatileCachedFactorizer =
            new com.jay.thread.chap03.VolatileCachedFactorizer();
    ExecutorService exec = Executors.newFixedThreadPool(100);

    ServletRequest req;
    ServletResponse res;

    @Before
    public void setUp() {
        req = PowerMockito.mock(ServletRequest.class);
        res = PowerMockito.mock(ServletResponse.class);
    }

    @Test
    public void service() throws Exception {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            exec.submit(new Runnable() {
                public void run() {
                    try {
                        volatileCachedFactorizer.service(req, res);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            exec.submit(new Runnable() {
                public void run() {
                    try {
                        volatileCachedFactorizer.service(req, res);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("总耗时:" + (System.currentTimeMillis() - startTime));
    }

}