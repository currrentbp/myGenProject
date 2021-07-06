package com.currentbp.test.interfaceTest.multInterface;

import org.junit.Test;

public class UseImplInterface {
    @Test
    public void t1(){
        Interface1 interface1 = new ImplInterface();
        Interface2 interface2 = new ImplInterface();

        interface1.sayHello1("11111");
        interface2.sayHello2("22222");
    }
}
