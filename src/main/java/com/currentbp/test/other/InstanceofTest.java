package com.currentbp.test.other;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190708
 */
public class InstanceofTest {
    @Test
    public void t1(){
        boolean b = null instanceof Student;
        StringUtil.printObject(b);
    }

    @Test
    public void  t2(){
        Object[] t = new Object[]{"s1"};
        StringUtil.printObject("==>s1:{},s2:{}",t);
    }
}
