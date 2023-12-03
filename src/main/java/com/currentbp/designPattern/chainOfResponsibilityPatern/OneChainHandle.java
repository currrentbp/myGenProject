package com.currentbp.designPattern.chainOfResponsibilityPatern;

import com.currentbp.util.all.StringUtil;

import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:22
 */
public class OneChainHandle implements AbstractChainHandler {

    @Override
    public void doSomeThing(Map<String, Object> paramsMap, Map<String, Object> resultMap) {
        String breakNow = (String)paramsMap.get("breakNow");
        if("true".equals(breakNow)){
            return;
        }

        System.out.println("oneChainHandle =========");
        StringUtil.printObject(paramsMap);
        StringUtil.printObject(resultMap);
        paramsMap.put("k1","k1");
        resultMap.put("v1","v1");
        System.out.println("oneChainHandle =========");
    }
}
