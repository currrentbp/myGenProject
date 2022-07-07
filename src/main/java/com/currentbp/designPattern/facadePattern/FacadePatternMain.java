package com.currentbp.designPattern.facadePattern;

public class FacadePatternMain {
    public static void main(String[] args) {
        FacadeXXX facadeXXX = new FacadeXXX();
        int i = facadeXXX.doGenStudent("123");
        System.out.println("i:" + i);
    }
}
