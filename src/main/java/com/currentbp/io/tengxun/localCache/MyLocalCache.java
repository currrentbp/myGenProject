package com.currentbp.io.tengxun.localCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author baopan
 * @createTime 2023-06-10 22:21:08
 */
public class MyLocalCache {
    private Map<String, Queue<String>> cache = new HashMap<>();

    public String getContent(String toUid) {
        Queue<String> queue = cache.get(toUid);
        if (queue == null) {
            queue = new LinkedBlockingQueue<String>();
        }
        String poll = queue.poll();
        return poll;
    }
}
