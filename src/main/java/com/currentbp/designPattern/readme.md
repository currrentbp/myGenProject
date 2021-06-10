#23种设计模式：

[markdown在线学习](http://www.mdeditor.com/)

#已完成部分
单例模式、工厂模式、抽象工厂模式、建造者模式

##1、单例模式：
确保一个类在任何情况下都绝对只有一个实例，并提供一个全局访问点。
代码在singleton路径下
###1.1、饿汉式单例：HungrySingleton
单例模式的饿汉式就是在类刚被加载的时候，马上就创建对象，生怕抢不到吃的
###1.2、懒汉式单例：LazySingleton（使用了双锁机制）
懒汉式的方式就是，一开始比较懒，不去创建对象，等到程序需要我的时候，实在没法再拖了，就只能创建对象了
###1.3、注册式单例
使用枚举获取对象

##2、工厂模式
在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

代码在FactoryPattern下

1. 1个接口：描述了需要做的动作
2. 3个类分别实现了这个接口，并且实现的具体是不同的
3. 一个工厂类中一个方法通过类型获取对应的实体对象

##3、抽象工厂模式
抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。
该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

代码在AbstractFactorPattern下

其实就是在工厂模式的基础上建立一个超大工厂，囊括现有的工厂模式


##4、建造者模式
建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。
这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

代码在BuilderPattern下，[参考博客](https://www.runoob.com/design-pattern/builder-pattern.html)

1. 接口：商品类，接口：打包类
2. 打包类型的实现类：Wrapper（包装袋）、Bottle（杯子）
    商品类的抽象实现类：Burger（汉堡）、ColdDrink（冷饮）
    商品抽象类的具体实现类：VegBurger（蔬菜汉堡）、ChickenBurger（鸡肉汉堡）、Coke（可口可乐）、Pepsi（百事可乐）


##5、 原型模式


##6、 策略模式 strategyPattern



##7、 代理模式 proxyPattern

##8、 门面模式 FacadePattern
~~~
1、业务实现层：serviceImpl
2、门面实现层：facade层
~~~

##9、 适配器模式 adapterPattern
~~~
适配器模式有两种：类适配器模式，对象适配器模式
base:
1、内部用户信息的接口和接口实现：IUserInfo,UserInfoImpl
2、外部用户信息的接口和接口实现：IOutUserInfo,OutUserInfoImpl
3、最初原始调用的方法：UseAdapterPattern
4、增加一个中间实现，使之改动最小，UseOutUserInfo，这个类继承了OutUserInfoImpl，实现了IUserInfo
5、再在UseAdapterPattern稍微修改一下类，使之调用方修改最少

1、类适配模式： base
2、对象适配式： 就是将OutUserInfoImpl的继承关系变成内部成员变量
~~~

##10、  模板方法模式 templateMethodPattern
~~~
板方法模式就是在模板方法中按照一个的规则和顺序调用基本方法

~~~

##11、 桥梁模式 bridgePattern
```


```
##12、 命令模式 commandPattern
```
实用场景：
高思教育的：物流相关接口：不同的仓库，通过指定的仓库code获取对应的结果

group角色：干活的角色
command角色：命令
invoker角色：调用者

缺点：由于功能的增加，命令种类也在增加，类的量也在增加

```

##13、 装饰模式 decoratorPattern
```
类似坦克大战的饰品装饰

```

##14、  迭代器模式  iteratorPattern
```
111111


```











