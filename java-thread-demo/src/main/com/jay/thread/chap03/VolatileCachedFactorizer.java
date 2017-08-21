package com.jay.thread.chap03;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

public class VolatileCachedFactorizer extends GenericServlet implements Servlet {
    private volatile com.jay.thread.chap03.OneValueCache cache = new com.jay.thread.chap03.OneValueCache(null,null);

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] facts = cache.getLastfacts(i);
        if (facts == null) {
            facts = factor(i);
            cache = new com.jay.thread.chap03.OneValueCache(i, facts);
        }
        encodeIntoResponse(res,facts);
    }
    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
