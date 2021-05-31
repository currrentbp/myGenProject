package com.currentbp.designPattern.adapterPattern;

import java.util.Map;

public interface IOutUserInfo {
    Map<String,String> getUserInfo();
    Map<String,String> getFamilyInfo();
    Map<String,String> getOfficialInfo();
}
