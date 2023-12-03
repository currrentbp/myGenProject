package com.currentbp.designPattern.chainOfResponsibilityPatern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:55
 */
public class ChainContext {

    private ChainContext next;
    private AbstractChainHandler handler;

    public ChainContext(AbstractChainHandler handler){
        this.handler = handler;
    }

    public ChainContext getNext() {
        return next;
    }

    public void setNext(ChainContext next) {
        this.next = next;
    }

    public AbstractChainHandler getHandler() {
        return handler;
    }

}
