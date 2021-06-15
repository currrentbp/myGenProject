package com.currentbp.designPattern.commandPattern;

public class RequirementCommand extends GroupCommand {
    @Override
    public void execute() {
        super.requirementGroup.add();
        super.requirementGroup.find();
    }
}
