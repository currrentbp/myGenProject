package com.currentbp.designPattern.chainOfResponsibilityPatern;

import com.currentbp.util.all.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:23
 */
public class UseChainOfResponsibilityPatternMain {
    public static void main(String[] args) {
        ChainResponsibilityPiple chainResponsibilityPiple = new ChainResponsibilityPiple();
        chainResponsibilityPiple.addLast(new OneChainHandle());
        chainResponsibilityPiple.addLast(new TwoChainHandler());

        Map<String, Object> params = new HashMap<>();
        params.put("s1", "s1");
        Map<String, Object> results = new HashMap<>();

        chainResponsibilityPiple.doChain(params, results);
        StringUtil.printObject(results);
    }
}
