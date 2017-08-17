package com.jay.thread.chap01;


import net.jcip.annotations.NotThreadSafe;

/**
 * UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value=0;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return ++value;
    }
}
