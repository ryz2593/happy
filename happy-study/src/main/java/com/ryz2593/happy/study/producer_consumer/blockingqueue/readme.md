使用concurrent.BlockingQueue

BlockingQueue是JDK5.0的新增内容，它是一个已经在内部实现了同步的队列，实现方式采用的是我们第2种await() / signal()方法。它可以在生成对象时指定容量大小，用于阻塞操作的是put()和take()方法。

put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞。

take()方法：类似于我们上面的消费者线程，容量为0时，自动阻塞。

```java
package com.ryz2593.happy.study.producer_consumer.blockingqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ryz2593
 */
public class Storage {
    /**
     * 仓库存储的载体
     */
    private LinkedBlockingDeque<Object> list = new LinkedBlockingDeque<>(10);

    public void producer() {
        try {
            list.put(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer() {
        try {
            list.take();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了一个产品，现库存" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


```

可能会出现put()或take()和System.out.println()输出不匹配的情况，是由于它们之间没有同步造成的。BlockingQueue可以放心使用，这可不是它的问题，只是在它和别的对象之间的同步有问题。