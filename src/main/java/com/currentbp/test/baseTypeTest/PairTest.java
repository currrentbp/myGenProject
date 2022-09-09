package com.currentbp.test.baseTypeTest;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220906
 */
public class PairTest {

    @Test
    public void eqPair(){

        List<Pair<String,String>> pairs = Lists.newArrayList(Pair.of("ru","ru"),Pair.of("id","id1"),Pair.of("es","es1"));
        System.out.println(pairs.contains(Pair.of("id", "id1")));
        System.out.println(pairs.contains(Pair.of("es","es2")));

    }
}
