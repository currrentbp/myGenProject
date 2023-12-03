package com.currentbp.designPattern.chainOfResponsibilityPatern;

import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:15
 */
public interface AbstractChainHandler {


    /**
     *
     * @param paramsMap {
     *                      "breakNow","true",//表示后续流程不需要做了
     *                      "k","v"
     *                  }
     * @param resultMap {
     *                      "errorCode":"100",//错误码
     *                      "returnValue":"object"//如果需要返回值的话，可以存在这里
     *                  }
     */
    abstract void doSomeThing( Map<String,Object> paramsMap,Map<String,Object> resultMap);
}
