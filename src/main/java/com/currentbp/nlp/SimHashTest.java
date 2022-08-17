package com.currentbp.nlp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author baopan
 * @createTime 20220816
 */
public class SimHashTest {
    @Test
    public void t1() {
        List<String> ls = Lists.newArrayList("我的祖国", "我的祖国是中国");
        Simhash simhash = new Simhash(4, 3);
        for (String content : ls) {
            Long simhashVal = simhash.calSimhash(content);
            System.out.println("content:" + content + ":" + Long.toBinaryString(simhashVal));
            System.out.println(simhash.isDuplicate(simhashVal));
            simhash.store(simhashVal, content);
        }
    }
}
