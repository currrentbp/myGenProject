package com.currentbp.designPattern.commandPattern;

public class FrontCommand extends GroupCommand {
    @Override
    public void execute() {
        super.frontGroup.add();
        super.frontGroup.find();
    }
}
