package com.currentbp.designPattern.adapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OutUserInfoImpl implements IOutUserInfo{
    @Override
    public Map<String, String> getUserInfo() {
        Map<String,String> result = new HashMap<>();
        result.put("myName","out baopan");
        result.put("myPhone","out 121");
        return result;
    }

    @Override
    public Map<String, String> getFamilyInfo() {
        Map<String,String> result = new HashMap<>();
        result.put("myAddress","out 11111");
        result.put("myFamily","out myFamily");
        return result;
    }

    @Override
    public Map<String, String> getOfficialInfo() {
        Map<String,String> result = new HashMap<>();
        result.put("myLevel","out 11");
        result.put("myLevelName","out 11Name");
        return result;
    }
}
