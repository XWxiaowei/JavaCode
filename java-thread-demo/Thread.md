Java 并发编程实践
      的学习和总结
      

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
