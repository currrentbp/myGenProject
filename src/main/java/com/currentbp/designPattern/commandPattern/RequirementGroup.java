package com.currentbp.designPattern.commandPattern;

public class RequirementGroup extends Group{
    @Override
    void add() {
        System.out.println("需求：增加一个功能");
    }

    @Override
    void delete() {
        System.out.println("需求：删除一个功能");
    }

    @Override
    void find() {
        System.out.println("需求：查询功能");
    }

    @Override
    void change() {
        System.out.println("需求：改变一个功能");
    }
}
