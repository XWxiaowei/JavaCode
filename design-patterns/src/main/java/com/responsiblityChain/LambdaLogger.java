package com.responsiblityChain;

import java.util.function.Consumer;

/**
 * 1. 通过@FunctionalInterface定义一个函数式接口
 *
 * @author xiang.wei
 * @date 2020/2/19 8:56 PM
 */
@FunctionalInterface
public interface LambdaLogger {
    int DEBUG = 1;
    int INFO = 2;
    int ERROR = 3;

    /**
     * 函数式接口中唯一的抽象方法
     *
     * @param message
     */
     void message(String message,int level);


    default LambdaLogger appendNext(LambdaLogger nextLogger) {
        return (msg,level)->{
          //前面logger处理完才用当前logger处理
            message(msg, level);
            nextLogger.message(msg, level);
        };
    }

   static LambdaLogger logMessage(int level, Consumer<String> writeMessage){
        //temLevel是日志处理器的级别，level是打印的日志级别
       return (message, temLevel) -> {
           if (temLevel >= level) {
               writeMessage.accept(message);
           }
        };
    }

    static LambdaLogger consoleLogMessage(int level1) {
       return logMessage(level1, (message) -> System.out.println("**********Console logger:" + message));
    }

    static LambdaLogger errorLogMessage(int level) {
        return  logMessage(level, message -> System.out.println("***********Error logger: " + message));
    }

    static LambdaLogger fileLogger(int level) {
        return logMessage(level, message -> System.out.println("*******File Logger: " + message));
    }


     static void main(String[] args) {
        LambdaLogger logger = consoleLogMessage(1).appendNext(fileLogger(2)).appendNext(errorLogMessage(3));
        //consoleLogger
        logger.message("控制台信息", 1);
        logger.message("文件信息", 2);
        logger.message("错误信息", 3);
    }
}
