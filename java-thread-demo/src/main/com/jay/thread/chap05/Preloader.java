package com.jay.thread.chap05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Future做闭锁
 * Created by xiang.wei on 2017/8/23
 */
public class Preloader {

    ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }
    private final Future<ProductInfo> future =
            new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws DataLoadException {
            return loadProductInfo();
        }
    });

    private final Thread thread = new Thread((Runnable) future);

    public  ProductInfo get() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface ProductInfo {
    }
    class DataLoadException extends Exception { }

}
