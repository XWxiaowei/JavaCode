package com.jay.spring.service.impl;

import com.jay.spring.service.SpringAnnoService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by xiang.wei on 2017/8/11.
 */
@RunWith(JUnit4.class)
public class SpringAnnoServiceImplTest extends
        AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private SpringAnnoService springAnnoService;

    @Before
    public void startUp() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        springAnnoService=applicationContext.getBean("springAnnoService",SpringAnnoService.class);
    }
    @Test
    public void testRollbackForException() {
        try {
            springAnnoService.rollbackForException();
        } catch (Exception e) {
        }finally {
            Assert.assertEquals(0,springAnnoService.mysqlConnection());
        }
    }
    @After
    public void testCleanUp() throws Exception {
        springAnnoService.cleanUp();
    }
}