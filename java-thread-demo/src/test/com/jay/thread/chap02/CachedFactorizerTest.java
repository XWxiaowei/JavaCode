package com.jay.thread.chap02;

import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by xiang.wei on 2017/8/17.
 */
public class CachedFactorizerTest extends BaseFactorizerTest{
    final CachedFactorizer cachedFactorizer = new CachedFactorizer();
    @Test
    public void testService() throws Exception {
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            exec.submit(new Runnable() {
                public void run() {
                    try {
                        cachedFactorizer.service(req, res);
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
                        cachedFactorizer.service(req, res);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("总耗时:"+(System.currentTimeMillis()-startTime));
    }
}