package com.currentbp.designPattern.adapterPattern;

public class UserInfoImpl implements IUserInfo{
    @Override
    public String getName() {
        return "bp";
    }

    @Override
    public String getPhone() {
        return "bp phone";
    }

    @Override
    public String getAddress() {
        return "bp address";
    }

    @Override
    public String getFamily() {
        return "bp family";
    }

    @Override
    public String getLevel() {
        return "bp level";
    }

    @Override
    public String getLevelName() {
        return "bp levelName";
    }
}
