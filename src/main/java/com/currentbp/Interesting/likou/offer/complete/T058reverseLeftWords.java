package com.currentbp.Interesting.likou.offer.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221221
 */
public class T058reverseLeftWords {

    @Test
    public void t1(){
        System.out.println(reverseLeftWords("abcdefg",2));
        System.out.println(reverseLeftWords("lrloseumgh",6));
    }

    public String reverseLeftWords(String s, int n) {
        String head = s.substring(0,n);
        String tail = s.substring(n);
        return tail+head;
    }
}
