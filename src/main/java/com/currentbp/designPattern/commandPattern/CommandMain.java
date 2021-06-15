package com.currentbp.designPattern.commandPattern;

public class CommandMain {
    public static void main(String[] args) {
//        RequirementCommend commend = new RequirementCommend();
        FrontCommand commend = new FrontCommand();
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.setCommend(commend);

        commandInvoker.invoke();
    }
}
