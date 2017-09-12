package com.jay.otherThread;

/**
 * 用于比较sleep()方法与wait()方法的不同
 * Created by xiang.wei on 2017/9/12
 */
public class MultiThread {

    private static class Thread1 implements Runnable {

        @Override
        public void run() {
            //由于 Thread1和下面Thread2内部run方法要用同一对象作为监视器，如果用this则Thread1和Threa2的this不是同一对象
            //所以用MultiThread.class这个字节码对象，当前虚拟机里引用这个变量时指向的都是同一个对象
            synchronized (MultiThread.class) {
                System.out.println("进入 Threa1");
                System.out.println("Thead1 is waiting");
                try {
                    //释放锁有两种方式：(1)程序自然离开监视器的范围，即离开synchronized关键字管辖的代码范围
                    //(2)在synchronized关键字管辖的代码内部调用监视器对象的wait()方法。这里使用wait方法
                    MultiThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 is going on.....");
                System.out.println("Thread1 is being cover");
            }
        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (MultiThread.class) {
                System.out.println("进入 Thread2");
                System.out.println("Thread2 is sleep 10 second");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 is going on.....!");
                System.out.println("Thread2 is being cover!");
            }
        }
    }

    public static void main(String[] args) {
        //启动Thread1
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }
}
