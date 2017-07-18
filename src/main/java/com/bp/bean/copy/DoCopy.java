package com.bp.bean.copy;

import com.bp.util.all.CglibCopyBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * copy bean的测试类
 *
 * @author current_bp
 * @createTime 20170718
 */
public class DoCopy {

    /**
     * 测试表明时间类型无法转成long
     * 其他的都转换了
     */
    @Test
    public void copy1() {
        Other other = new Other();
        other.setO1(11);
        List<Other> others = new ArrayList<Other>();
        others.add(other);
        Second second = new Second();
        second.setSe1("s1");
        second.setDate(new Date());

        First first = new First();
        first.setF1(22);
        first.setDate(new Date());
        first.setS1("s111");
        first.setSecond(second);
        first.setOthers(others);


        FirstCopy firstCopy = new FirstCopy();
        CglibCopyBean.BasicCopyBean(first, firstCopy);
        Assert.assertTrue(null != firstCopy);

    }
}
