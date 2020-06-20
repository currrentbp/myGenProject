这个文件中的类都是关于锁的
例如：
1、两个线程按照顺序打印字符串

解决：
1、AtomicIntegerPrint：利用AtomicInteger作为一个锁，通过compareAndSet（param1：期望值，param2：设置值）来实现锁机制的，
两个线程，都是通过无限制的获取atomicInteger的值来判断获得的值是否和自己期望的一致，如果一致则跳出自我循环，执行剩下的任务

2、








