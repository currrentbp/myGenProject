[markdown的在线教程：http://www.mdeditor.com/](http://www.mdeditor.com/)

1、BeanA->BeanB->BeanC->BeanA
依赖是使用构造器依赖
a依赖于b，b依赖于c，c依赖于a

2、BeanA1->BeanB1->BeanC1->BeanA1
a1依赖于b1，b1依赖于c1，c1依赖于a1

相关博客：
https://www.jianshu.com/p/8bb67ca11831

1、构造器中相互依赖，导致循环依赖，启动报错
原因：构造器中的bean是临时创建的bean无法做到案例2中的三级缓存。
从流程上就可以查看，无论是构造注入还是设值注入，第二次进入同一个Bean的getBean方法时，
一定会在校验部分抛出异常，因此不能完成注入，也就不能实现循环引用。



2、通过field自动注入的相互依赖，虽然会有循环依赖，但是启动不会报错，
原因：有三级缓存，第一次初始化的时候将beanA1放入了三级缓存中，然后等到
beanC1获取beanA1时，触发了getBean(beanA1)，此时能拿到A了，也就顺理成章的获取到了B,再向上时能获取到A了。
总结：Spring在InstantiateBean时执行构造器方法，构造出实例，如果是单例的话，
会将它放入一个singletonBeanFactory的缓存中，再进行populateBean方法，设置属性。
通过一个singletonBeanFactory的缓存解决了循环依赖的问题。

一级缓存：
保存所有的singletonBean的实例
private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

二级缓存：
保存所有早期创建的Bean对象，这个Bean还没有完成依赖注入 
private final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>(16);
三级缓存：
singletonBean的生产工厂
private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>(16);

