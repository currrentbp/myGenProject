nio: non-blocking IO

NIO三大核心部分：Channel(通道),Buffer(缓冲区),Selector(选择器)
    
~~~
                                                    --->channel1(通道)
            --->    thread1 ---> selector（选择器）   --->channel2(通道)   --->buffer(缓冲区)
   server   --->    thread2
            --->    thread3....
~~~


