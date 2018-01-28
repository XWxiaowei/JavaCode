package com.jay.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by xiang.wei on 2018/1/28
 *
 * @author xiang.wei
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandler traceHandler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, traceHandler);
            elements[i] = proxy;

            Integer key = new Random().nextInt(elements.length) - 1;
            int result = Arrays.binarySearch(elements, key);
            if (result >= 0) {
                System.out.println(elements[result]);
            }
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target);
        System.out.println("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1) {
                    System.out.println(",");
                }
            }
            System.out.println(")");
        }
        return method.invoke(target, args);
    }
}
