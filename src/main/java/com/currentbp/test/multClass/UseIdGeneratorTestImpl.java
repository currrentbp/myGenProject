package com.currentbp.test.multClass;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/9/10 22:47
 */
public class UseIdGeneratorTestImpl {
    @Test
    public void use(){
        IdGeneratorTestImpl idGeneratorTestImpl = new IdGeneratorTestImpl();
        IdGeneratorTest idGenerator = idGeneratorTestImpl.createIdGenerator("123");
        idGenerator.set(10L);
        long generate = idGenerator.generate();
        System.out.println(generate);
    }
}
