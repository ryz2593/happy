# `前言`
分布式锁一般有三种实现方式：1. 数据库乐观锁；2. 基于Redis的分布式锁；3. 基于ZooKeeper的分布式锁。本篇博客将介绍第二种方式，基于Redis实现分布式锁。

# `可靠性`
首先，为了确保分布式锁可用，我们至少要确保锁的实现同时满足以下四个条件：

1. 互斥性。在任意时刻，只有一个客户端能持有锁。
2. 不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。
3. 具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。
4. 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。



## Redis
1. [Redis的list数据结构 lpush、rpush、lpop、rpop等常用操作][RedisListOperation]
2. [redis分布式锁原理与实现][DistributedLock]
3. [使用Redis中的zset（有序列表）实现延时队列 JAVA实现][DelayQueue]
4. [使用Redis来实现简单限流策略][RateLimiter]



[Redis]: Redis链接
[RedisListOperation]: https://blog.csdn.net/mengqingming1/article/details/103186553
[RateLimiter]: https://blog.csdn.net/mengqingming1/article/details/103234000
[DelayQueue]: https://blog.csdn.net/mengqingming1/article/details/103196701
[DistributedLock]: https://blog.csdn.net/mengqingming1/article/details/103176397

