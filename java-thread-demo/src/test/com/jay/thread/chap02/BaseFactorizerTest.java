package com.jay.thread.chap02;

import org.junit.Before;
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
public class BaseFactorizerTest {
    ExecutorService exec = Executors.newFixedThreadPool(100);

    ServletRequest req;
    ServletResponse res;

    @Before
    public void setUp() {
        req = PowerMockito.mock(ServletRequest.class);
        res = PowerMockito.mock(ServletResponse.class);
    }
}
