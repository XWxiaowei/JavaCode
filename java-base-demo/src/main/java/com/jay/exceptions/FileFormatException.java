package com.jay.exceptions;

import java.io.IOException;

/**
 * 自定义异常类
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class FileFormatException extends IOException {
    public FileFormatException() {

    }

    public FileFormatException(String msg) {
        super(msg);
    }

}
