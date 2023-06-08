```
这个文件夹下的测试：
只有一个接口，如何使用动态代理将bean维护到spring中

具体实现：
1、弄一个proxy代理类实现接口InvocationHandler类，
    这个类中只需要实现一个方法就是invoke方法。
2、在这个invoke方法中其实就是一个钩子方法，

```