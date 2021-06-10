package com.currentbp.designPattern.commandPattern;

public class FrontGroup extends Group{
    @Override
    void add() {
        System.out.println("前端：增加一个功能");
    }

    @Override
    void delete() {
        System.out.println("前端：删除一个功能");
    }

    @Override
    void find() {
        System.out.println("前端：查询功能");
    }

    @Override
    void change() {
        System.out.println("前端：改变一个功能");
    }
}
