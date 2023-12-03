package com.currentbp.designPattern.chainOfResponsibilityPatern;

import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/16 11:24
 */
public class ChainResponsibilityPiple {
    private ChainContext context;

    public void addLast(AbstractChainHandler handler) {
        if (context == null) {
            context = new ChainContext(handler);
        } else {
            ChainContext head = context;
            while (head.getNext() != null) {
                head = head.getNext();
            }
            head.setNext(new ChainContext(handler));
        }
    }

    public void doChain(Map<String, Object> params, Map<String, Object> results) {
        while (context != null) {
            AbstractChainHandler handler = context.getHandler();
            handler.doSomeThing(params, results);
            context = context.getNext();
        }
    }
}
