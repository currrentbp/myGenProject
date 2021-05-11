package com.currentbp.designPattern.adapterPattern;

public class UseOutUserInfo extends OutUserInfoImpl implements IUserInfo{
    @Override
    public String getName() {
        return this.getUserInfo().get("myName");
    }

    @Override
    public String getPhone() {
        return this.getUserInfo().get("myPhone");
    }

    @Override
    public String getAddress() {
        return this.getFamilyInfo().get("myAddress");
    }

    @Override
    public String getFamily() {
        return this.getFamilyInfo().get("myFamily");
    }

    @Override
    public String getLevel() {
        return this.getOfficialInfo().get("myLevel");
    }

    @Override
    public String getLevelName() {
        return this.getOfficialInfo().get("myLevelName");
    }
}
