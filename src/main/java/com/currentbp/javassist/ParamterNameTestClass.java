package com.currentbp.javassist;

/**
 * 用于测试的方法
 *
 * @author baopan
 * @createTime 20181220
 */
public class ParamterNameTestClass {
    public void sayHello(String content) {
        System.out.println("hello: " + content);
    }

    public void sayStop(String name) {
        System.out.println("" + name + " stop!!");
    }

    public void sayNull() {
        System.out.println("say null!");
    }

    private void allSay(String s1) {
    }

    ;
}
