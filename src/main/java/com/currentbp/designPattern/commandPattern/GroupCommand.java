package com.currentbp.designPattern.commandPattern;

public abstract class GroupCommand {
    protected CodeGroup codeGroup = new CodeGroup();
    protected FrontGroup frontGroup = new FrontGroup();
    protected RequirementGroup requirementGroup = new RequirementGroup();

    public abstract void execute();

}
