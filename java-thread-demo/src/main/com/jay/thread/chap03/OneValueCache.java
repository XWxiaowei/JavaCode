package com.jay.thread.chap03;

import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {
    private final BigInteger lastnumber;
    private final BigInteger[] lastfacts;

    public OneValueCache(BigInteger lastnumber,
                         BigInteger[] lastfacts) {
        this.lastnumber = lastnumber;
        this.lastfacts = Arrays.copyOf(lastfacts,lastfacts.length);
    }

    public BigInteger[] getLastfacts(BigInteger i) {
        if (lastnumber == null || !lastnumber.equals(i)) {
            return null;
        } else return Arrays.copyOf(lastfacts, lastfacts.length);
    }
}
