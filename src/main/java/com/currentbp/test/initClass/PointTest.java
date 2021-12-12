package com.currentbp.test.initClass;

public class PointTest {
    double x = 2.0;
    public Cycle cycle = new Cycle(2);
    void printBoth() {
        System.out.println(x + " haha");
    }

}

class Cycle {
    double y = 1.0;
    public Cycle(double y){this.y = y;}
    void printY() {
        System.out.println(y + "ssssssssssss");
    }
}

class Test extends PointTest {
    double x = 4.7;
    public Cycle cycle = new Cycle(3);
    void printBoth() {
        System.out.println(x + " " + super.x);
    }

    public static void main(String[] args) {
        Test sample = new Test();
        System.out.println("sample's hashcode:" + sample.hashCode());
        sample.printBoth();
        PointTest pointTest = (PointTest) sample;
        /*
        0、强转前，子类有两个x，一个是父类的一个是子类的，强转后，同样有两个x，一个是父类，一个是子类
        1、这两个对象的hashcode是相等的
        2、强转后，成员变量的指针指向的是父类的成员属性
        3、强转后，由于本身的类型已定，执行的方法是子类的
         */
        System.out.println("pointTest's hashcode:" + pointTest.hashCode());
        double x1 = pointTest.x;
        Cycle cycle = pointTest.cycle;
        System.out.println(sample.x + " " + (pointTest).getClass() + " " + x1);
        ((PointTest) sample).printBoth();
    }
}
