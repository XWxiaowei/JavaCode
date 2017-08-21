package com.jay.thread.chap02;

import org.junit.Test;

/**
 * Created by xiang.wei on 2017/8/17.
 */

public class SynchronizedFactorizerTest extends BaseFactorizerTest {
    final SynchronizedFactorizer synchronizedFactorizer = new SynchronizedFactorizer();

    @Test
    public void testService() throws Exception {
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            exec.submit(new Runnable() {
                public void run() {
                    synchronizedFactorizer.service(req, res);
                }
            });
            exec.submit(new Runnable() {
                public void run() {
                    synchronizedFactorizer.service(req, res);
                }
            });
        }
        System.out.println("总耗时:"+(System.currentTimeMillis()-startTime));
    }
}