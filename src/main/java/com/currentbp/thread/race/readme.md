这个文件中的类都是关于锁的
例如：
1、两个线程按照顺序打印字符串

解决：
1、AtomicIntegerPrint：利用AtomicInteger作为一个锁，通过compareAndSet（param1：期望值，param2：设置值）
来实现锁机制的，
两个线程，都是通过无限制的获取atomicInteger的值来判断获得的值是否和自己期望的一致，
如果一致则跳出自我循环，执行剩下的任务。
这种方法会使cpu空转。

2、BlockingQueuePrint:没有实现

3、LockSupportPrint：利用了LockSupport对其他线程的唤醒，对自己线程的阻塞

4、SemaphorePrint：利用的是semaphore的是否有型号量来控制是否能执行，如果没有型号量，
此时使用acquire，会导致程序在此处阻塞，一旦有了型号量时，会直接唤醒

5、SynchronizedPrint：利用最原始的synchronized








