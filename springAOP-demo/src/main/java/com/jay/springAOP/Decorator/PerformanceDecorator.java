package com.jay.springAOP.Decorator;

/**
 * 一个用于性能的统计的装饰器
 * Created by xiang.wei on 2017/8/14.
 */
public class PerformanceDecorator implements Command{
    Command cmd;
    public PerformanceDecorator(Command command){
        this.cmd=command;
    }

    public void execute() {
        System.out.println("开始时间:"+System.currentTimeMillis());
        this.cmd.execute();
        System.out.println("结束时间:"+System.currentTimeMillis());
    }
}
