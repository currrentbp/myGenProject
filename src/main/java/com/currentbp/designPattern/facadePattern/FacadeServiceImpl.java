package com.currentbp.designPattern.facadePattern;

public class FacadeServiceImpl implements FacadeService {
    @Override
    public int genStudent(String name) {
        System.out.println("name:" + name);
        return 0;
    }
}
