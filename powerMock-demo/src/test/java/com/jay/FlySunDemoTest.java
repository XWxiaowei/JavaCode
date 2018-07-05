package com.jay;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * @author xiang.wei
 * @create 2018/7/5 13:56
 */
@RunWith(PowerMockRunner.class)
public class FlySunDemoTest {

    @Test
    public void callArgumentInstance() {
        File file = PowerMockito.mock(File.class);
        FlySunDemo flySunDemo = new FlySunDemo();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(flySunDemo.callArgumentInstance(file));

    }
    @PrepareForTest(FlySunDemo.class)
    @Test
    public void callArgumentInstance2() {
        File file = PowerMockito.mock(File.class);

        try {
            PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
            FlySunDemo flySunDemo = new FlySunDemo();
            PowerMockito.when(file.exists()).thenReturn(true);
            Assert.assertTrue(flySunDemo.callArgumentInstance2("bbb"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testCallStaticMethod() {
        PowerMockito.mockStatic(ClassDependency.class);
        PowerMockito.when(ClassDependency.isStaticAlive()).thenReturn(true);
        FlySunDemo flySunDemo = new FlySunDemo();
        Assert.assertTrue(flySunDemo.callStaticMethod());

    }
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testCallFinalMethod() {
        ClassDependency refer = PowerMockito.mock(ClassDependency.class);
        PowerMockito.when(refer.isFinalAlive()).thenReturn(false);
        FlySunDemo flySunDemo = new FlySunDemo();
        Assert.assertFalse(flySunDemo.callFinalMethod(refer));

    }
    @Test
    @PrepareForTest(FlySunDemo.class)
    public void callPrivateMethod() throws Exception {
        FlySunDemo demo = PowerMockito.mock(FlySunDemo.class);
        PowerMockito.when(demo.callPrivateMethod()).thenCallRealMethod();
        PowerMockito.when(demo, "isAlive").thenReturn(true);
        Assert.assertTrue(demo.callPrivateMethod());

    }
    @Test
    @PrepareForTest(FlySunDemo.class)
    public void testCallSystemStaticMethod() {
        FlySunDemo flySunDemo = new FlySunDemo();
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        Assert.assertEquals("bbb",flySunDemo.callSystemStaticMethod("aaa"));
    }

}