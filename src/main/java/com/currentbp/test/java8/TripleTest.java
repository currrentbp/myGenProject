package com.currentbp.test.java8;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210729
 */
public class TripleTest {

    @Test
    public void useTriple() {
        Triple<Boolean, Long, Integer> value = Triple.of(true, 1L, 1);
        Boolean left = value.getLeft();
        Long middle = value.getMiddle();
        Integer right = value.getRight();
        System.out.println("left:" + left + " middle:" + middle + " right:" + right);
    }
}
