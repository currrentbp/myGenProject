package com.currentbp.designPattern.facadePattern;

public class FacadeXXX {
    private FacadeService facadeService;
    public FacadeXXX(){
        facadeService = new FacadeServiceImpl();
    }
    public int doGenStudent(String name){
        return facadeService.genStudent(name);
    }
}
