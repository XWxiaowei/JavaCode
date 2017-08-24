package com.jay.thread.chap05;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 *
 * Created by xiang.wei on 2017/8/23
 */
public class BoundedHashSet {
    private final Set<Integer> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(Integer integer) throws InterruptedException {
        //如果没有许可，那么acquire将阻塞直到有许可。
//        release方法将返回一个许可信号量
        semaphore.acquire();
        boolean semAdd = false;
        try {
            semAdd = set.add(integer);
            
            return semAdd;
        } finally {
            if (!semAdd) {
                semaphore.release();
            }
        }
    }

    public  boolean remove(Integer integer) {
        boolean semRem = set.remove(integer);
        if (semRem) {
            semaphore.release();
        }
        return semRem;

    }
}
