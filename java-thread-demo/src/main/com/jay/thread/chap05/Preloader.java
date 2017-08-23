package com.jay.thread.chap05;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Future做闭锁
 * Created by xiang.wei on 2017/8/23
 */
public class Preloader {
//    public
    private final Future<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return null;
        }
    }) {

    };

    interface ProductInfo {
    }

}
