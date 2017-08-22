Java 模拟瞬间高并发
  参考于：http://blog.csdn.net/zhao9tian/article/details/40346899
  前些日子接到了一个面试电话，面试内容我印象很深，如何模拟一个并发？当时我的回答虽然也可以算是正确的，但自己感觉缺乏实际可以操作的细节，只有一个大概的描述。
  当时我的回答是：“线程全部在同一节点wait，然后在某个节点notifyAll。”
  面试官：“那你听说过惊群效应吗？”
  我：“我没有听过这个名词，但我知道瞬间唤醒所有的线程，会让CPU负载瞬间加大。”
  面试官：“那你有什么改进的方式吗？”
  我：“采用阻塞技术，在某个节点将所有的线程阻塞，在利用条件，线程的个数达到一定数量的时候，打开阻塞。”
  面试官好像是比较满意，结束了这个话题。
  面试结束后，我回头这个块进行了思考，要如何进行阻塞呢？我首先有一个思路就是，利用AtoInteger计算线程数，再利用synchronize方法块阻塞一个线程，根据AtoInteger的判断，执行sleep。      

```
package com.jay.otherThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用AtoInteger计算线程数，再利用synchronize方法块阻塞一个线程，
 * 根据AtoInteger的判断，执行sleep。
 * Created by xiang.wei on 2017/8/22
 */
public class CountDownLatchTest1 implements Runnable {
    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;
    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this) {
            try {
                if (!bol) {
                    System.out.println(bol);
                    bol = true;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("并发数量为："+number.intValue());
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatchTest1 test = new CountDownLatchTest1();
        for (int i = 0; i <10 ; i++) {
            exec.submit(test);
        }
        exec.shutdown();
    }
}


```
从结果上来看，应该是可以解决问题，利用了同步锁，volatile解决了同时释放的问题，难点就在于开关。
后来查找资料，找到了一个CountDownLatch的类，专门干这个的
CountDownLatch是一个同步辅助类，犹如倒计时计数器，创建对象时通过构造方法设置初始值，
调用CountDownLatch对象的await()方法则处于等待状态，
调用countDown()方法就将计数器减1，当计数到达0时，则所有等待者或单个等待者开始执行。
CountDownLatch是一个同步辅助类，犹如倒计时计数器，创建对象时通过构造方法设置初始值，调用CountDownLatch对象的await()方法则处于等待状态，调用countDown()方法就将计数器减1，当计数到达0时，则所有等待者或单个等待者开始执行。
构造方法参数指定了计数的次数
```
new CountDownLatch(1) 
```
countDown方法，当前线程调用此方法，则计数减一

```
cdAnswer.countDown();  
```
awaint方法，调用此方法会一直阻塞当前线程，直到计时器的值为0
```
cdOrder.await();  
```
下面是采用CountDownLatch做的一个模拟高并发的demo
```
package com.jay.otherThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiang.wei on 2017/8/22
 * 该程序用来模拟发送命令与执行命令，主线程代表指挥官，新建3个线程代表战士，战士一直等待着指挥官下达命令，
 * 若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，战士们都去执行自己的任务，
 * 指挥官处于等待状态，战士们任务执行完毕则报告给
 * 指挥官，指挥官则结束等待。
 */
public class CountdownLatchTest {
    final static ExecutorService exec = Executors.newCachedThreadPool();//创建一个线程池
    final static CountDownLatch cdOrder = new CountDownLatch(1);//指挥官命令，只有一个指挥官
    final static CountDownLatch cdAnswer = new CountDownLatch(3); //战士命令，有三个战士

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令！");
                        cdOrder.await();//战士在等待
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令！");
                        Thread.sleep((long) Math.random() * 1000);
                        System.out.println("线程" + Thread.currentThread().getName() + "已完成命令！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        cdAnswer.countDown(); //任务执行完毕，返回给指挥官
                    }
                }
            };
            exec.submit(runnable);
        }
        //指挥官发布命令
        try {
            System.out.println("线程" + Thread.currentThread().getName() +
                    "即将发布命令");
            cdOrder.countDown();
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已发送命令，正在等待结果");
            cdAnswer.await();//指挥官等待任务完成
            System.out.println("线程" + Thread.currentThread().getName() + "已经收到任务完成信号！");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        exec.shutdown();
    }
}
```
上述也是一种实现方式，用countDownLatch的await()方法，代替了synchronize 和 sleep的阻塞功能，通过countDown的方法来当做开关，和计算线程数量的一种方式。
区别的话，肯定是后者会好一些，因为第一种方式依靠sleep(xxx)来阻塞把握不好最短时间，太短了，可能来没有达到固定线程数就会打开开关。
至于两者性能上的区别，目前我还不得而知，有机会测试一下