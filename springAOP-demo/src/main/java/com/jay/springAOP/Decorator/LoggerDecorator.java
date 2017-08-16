package com.jay.springAOP.Decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一个用于记录日志的装饰器
 * Created by xiang.wei on 2017/8/14.
 */
public class LoggerDecorator implements Command {
    Command cmd;
    public LoggerDecorator(Command command){
        this.cmd=command;
    }

    public void execute() {
        Logger logger= LoggerFactory.getLogger(this.getClass());
        //记录日志
        logger.debug("-------起始操作----------");
        this.cmd.execute();
        logger.debug("-------结束操作-----------");
    }
}
