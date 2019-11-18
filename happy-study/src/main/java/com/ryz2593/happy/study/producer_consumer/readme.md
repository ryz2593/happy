生产者消费者问题（Producer-consumer problem），也称有限缓冲问题（Bounded-buffer problem），是一个多线程同步问题的经典案例。
生产者生成一定量的数据放到缓冲区中，然后重复此过程；与此同时，消费者也在缓冲区消耗这些数据。
生产者和消费者之间必须保持同步，要保证生产者不会在缓冲区满时放入数据，消费者也不会在缓冲区空时消耗数据。
不够完善的解决方法容易出现死锁的情况，此时进程都在等待唤醒。



**Java能实现的几种方法**

1. 用synchronized对存储加锁，然后用object原生的wait() 和 notify()做同步。

2. 用concurrent.locks.Lock，然后用condition的await() 和signal()做同步。

3. 直接使用concurrent.BlockingQueue。

4. 使用PipedInputStream/PipedOutputStream。

5. 使用信号量semaphore。　

参考：

https://blog.csdn.net/ldx19980108/article/details/81707751

https://blog.csdn.net/xindoo/article/details/80004003

https://blog.csdn.net/qq_33006397/article/details/82657596
