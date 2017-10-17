package com.bp.gc.compile.init;

/**
 * 动态分配的问题
 * @author current_bp
 * @createTime 20171017
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
/*
我们使用javap命令输出这段代码的字节码，尝试从
中寻找答案，输出结果如代码清单8-9所示。
代码清单8-9 main（）方法的字节码public static void main（java.lang.String[]）；
Code：
Stack=2，Locals=3，Args_size=1
0：new#16；//class org/fenixsoft/polymorphic/DynamicDispatch $Man
3：dup
4：invokespecial#18；//Method org/fenixsoft/polymorphic/DynamicDispatch $Man."＜init＞"：（）V
7：astore_1
8：new#19；//class org/fenixsoft/polymorphic/DynamicDispatch $Woman
11：dup
12：invokespecial#21；//Method org/fenixsoft/polymorphic/DynamicDispa
tch $Woman."＜init＞"：（）V
15：astore_2
16：aload_1
17：invokevirtual#22；//Method org/fenixsoft/polymorphic/DynamicDispatch $Human.sayHello：（）V
20：aload_2
21：invokevirtual#22；//Method org/fenixsoft/polymorphic/DynamicDispatch $Human.sayHello：（）V
24：new#19；//class org/fenixsoft/polymorphic/DynamicDispatch $Woman
27：dup
28：invokespecial#21；//Method org/fenixsoft/polymorphic/Dynam
icDispatch $Woman."＜init＞"：（）V
31：astore_1
32：aload_1
33：invokevirtual#22；//Method org/fenixsoft/polymorphic/
DynamicDispatch $Human.sayHello：（）V
36：return
0～15行的字节码是准备动作，作用是建立man和woman的内存空间、 调用Man和Woman
类型的实例构造器，将这两个实例的引用存放在第1、 2个局部变量表Slot之中，这个动作也
就对应了代码中的这两句：
Human man=new Man（）；
Human woman=new Woman（）；
接下来的16～21句是关键部分，16、 20两句分别把刚刚创建的两个对象的引用压到栈
顶，这两个对象是将要执行的sayHello（）方法的所有者，称为接收者（Receiver）；17和21
句是方法调用指令，这两条调用指令单从字节码角度来看，无论是指令（都是
invokevirtual）还是参数（都是常量池中第22项的常量，注释显示了这个常量是
Human.sayHello（）的符号引用）完全一样的，但是这两句指令最终执行的目标方法并不相
同。 原因就需要从invokevirtual指令的多态查找过程开始说起，invokevirtual指令的运行时解
析过程大致分为以下几个步骤：
1）找到操作数栈顶的第一个元素所指向的对象的实际类型，记作C。
2）如果在类型C中找到与常量中的描述符和简单名称都相符的方法，则进行访问权限校
验，如果通过则返回这个方法的直接引用，查找过程结束；如果不通过，则返回
java.lang.IllegalAccessError异常。
3）否则，按照继承关系从下往上依次对C的各个父类进行第2步的搜索和验证过程。
4）如果始终没有找到合适的方法，则抛出java.lang.AbstractMethodError异常。
由于invokevirtual指令执行的第一步就是在运行期确定接收者的实际类型，所以两次调
用中的invokevirtual指令把常量池中的类方法符号引用解析到了不同的直接引用上，这个过
程就是Java语言中方法重写的本质。 我们把这种在运行期根据实际类型确定方法执行版本的
分派过程称为动态分派
 */
