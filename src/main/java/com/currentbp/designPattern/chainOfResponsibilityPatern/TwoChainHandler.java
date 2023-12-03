package com.currentbp.designPattern.chainOfResponsibilityPatern;

import com.currentbp.util.all.StringUtil;

import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:22
 */
public class TwoChainHandler implements AbstractChainHandler {

    @Override
    public void doSomeThing( Map<String, Object> paramsMap, Map<String, Object> resultMap) {
        String breakNow = (String)paramsMap.get("breakNow");
        if("true".equals(breakNow)){
            return;
        }

        System.out.println("twoChainHandle =========");
        StringUtil.printObject(paramsMap);
        StringUtil.printObject(resultMap);
        paramsMap.put("k2","k2");
        resultMap.put("v2","v2");
        System.out.println("twoChainHandle =========");
    }
}
