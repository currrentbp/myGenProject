package com.currentbp.designPattern.commandPattern;

public class CodeGroup extends Group{
    @Override
    void add() {
        System.out.println("程序员：增加一个功能");
    }

    @Override
    void delete() {
        System.out.println("程序员：删除一个功能");
    }

    @Override
    void find() {
        System.out.println("程序员：查询功能");
    }

    @Override
    void change() {
        System.out.println("程序员：改变一个功能");
    }
}
