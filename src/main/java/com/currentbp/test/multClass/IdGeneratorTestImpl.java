package com.currentbp.test.multClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/9/10 22:44
 */
public class IdGeneratorTestImpl {
    public IdGeneratorTest createIdGenerator(final String key) {
        List<Long> result = new ArrayList<>();
        return new IdGeneratorTest() {
            @Override
            public void set(long value)  {
                result.add(value);
               System.out.println("set value:"+value);
            }

            @Override
            public long generate() {
                Long aLong = result.get(0);

                return aLong;
            }
        };
    }
}
