Java 并发编程实践
      的学习和总结
      
**第一章**

安全性的含义是"永远不发生糟糕的事情""，而活跃性则关注于另外一个目标，即"某件正确的事情最终会发生""。
当某个操作无法继续执行下去时，就会发生活跃性问题。在串行程序中，活跃性问题的形式之一就是造成无限循环，从而使循环之后
的代码无法得到执行，线程将带来其他一些活跃性问题。例如，如果线程A在等待线程B释放其持有的资源，而线程B永远都不释放该资源
那么A就会永久地等下去。第10章将介绍各种形式的活跃性问题，以及如何避免这些问题，包括死锁，饥饿，以及活锁。

**第四章**
```
@NotThreadSafe
class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}

@ThreadSafe
class GoodListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());
    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
```

   我们从此程序中可以看到在BadListHelper类中虽然putIfAbsent被声明为synchronized类型的变量，
但是，问题出在了在错误的锁上进行了同步。无论List使用哪一个锁来保护它的状态，可以确定的是，这个锁
并不熟ListHelper上的锁，ListHelper只是带来了同步的假象，尽管所有的链表操作都被声明为synchronized，
但却使用了不同的锁，这意味着putIfAbsent相对于List的其他操作来说并不是原子的，因此就无法确保当putIfAbsent
执行时另外一个线程不会修改链表。

   要想使这个方法能正确执行，必须是List在实现客户端加锁或者外部加锁时使用同一个锁。客户端加锁是指，对于使用
某个对象X的客户端代码，使用X本身用于保护其状态的锁来保护这段客户代码。要使用客户端加锁，你必须知道对象X使用的是
哪一个锁。

线程池：

  1、newFixedThreadPool  newFixedThreadPool将创建一个固定长度的线程池，每当提交一个任务是就创建一个线程，直到到达线程池的最大数量，这时线程池的规模将不再变化（如果某个线程由于发生了未预期的Exception而结束，那么线程池会补充一个新线程）

  2、newCachedThreadPool newCachedThreadPool将创建一个可缓存的线程池，如果线程池的当前规模超过了处理需求时，那么将回收空闲的线程，而当需求增加时，则可以添加新的线程，线程池的规模不存在任何限制。
  
  3、newSingleThreadExcetor newSingleThreadExcetor是一个单线程的Executor,它创建单个工作者线程来执行任务，如果这个线程异常结束，会创建另一个线程替代，newSingleThreadExcetor能确保依照任务在队列中的顺序来串行执行。
  
  4、newScheduledThreadPool newScheduledThreadPool创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer。
