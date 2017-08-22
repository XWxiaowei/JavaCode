package com.jay.thread.chap04;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by xiang.wei on 2017/8/22
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this") private int x, y;
    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get(){
        return new int[]{x, y};}

    public synchronized void set(int x, int y) {
        this.x=x;
        this.y = y;
    }
}
