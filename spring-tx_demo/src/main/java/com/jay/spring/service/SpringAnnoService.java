package com.jay.spring.service;

/**
 * Created by xiang.wei on 2017/8/11.
 */
public interface SpringAnnoService {
    int mysqlConnection();
    void rollbackForException() throws Exception;
    void cleanUp();


}
