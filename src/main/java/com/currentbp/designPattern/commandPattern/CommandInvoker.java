package com.currentbp.designPattern.commandPattern;

public class CommandInvoker {

    private GroupCommand commend ;

    public void setCommend(GroupCommand groupCommand){
        this.commend = groupCommand;
    }

    public void invoke(){
        this.commend.execute();
    }

}
