package com.currentbp.test;

/**
 * @author baopan
 * @createTime 20190815
 */
public class AgentParam {
    static class Human{}
    static  class Man extends Human{}
    static class Woman extends Human{}

    static void say(Human human){
        System.out.println("human");
    }
    static void say(Man man){
        System.out.println("man");
    }
    static void say(Woman woman){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Human human = new Human();
        AgentParam.say(human);
        human = new Man();
        AgentParam.say(human);
        Man man = new Man();
        AgentParam.say(man);
    }
}
