package com.currentbp.test.interfaceTest.multInterface;

public class ImplInterface implements Interface1,Interface2{
    @Override
    public void sayHello1(String s1) {
        System.out.println("interface1:"+s1);
    }

    @Override
    public void sayHello2(String s1) {
        System.out.println("interface2:"+s1);
    }
}
