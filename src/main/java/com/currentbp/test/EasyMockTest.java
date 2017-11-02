package com.currentbp.test;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * easymock的测试
 *
 * @author current_bp
 * @createTime 20170512
 */
public class EasyMockTest {


    @Test
    public void testListInEasyMock() {
        List list = EasyMock.createMock(List.class);
        // 录制过程

        // 期望方法list.set(0,1)执行2次，返回null，不抛出异常
        expect1: EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);
        // 期望方法list.set(0,1)执行1次，返回null，不抛出异常
        expect2: EasyMock.expect(list.set(2, 1)).andReturn(2);

        // 执行测试代码
        EasyMock.replay(list);
        // 执行list.set(0,1)，匹配expect1期望，会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect1（因为expect1期望执行此方法2次），会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect2，会返回1
        Assert.assertEquals(1, list.set(2, 1));

        // 验证期望
        EasyMock.verify(list);
    }
}
