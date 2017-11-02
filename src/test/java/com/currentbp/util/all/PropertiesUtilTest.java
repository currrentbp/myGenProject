package com.currentbp.util.all;

import org.junit.Test;

/**
 * 资源Util的测试类
 *
 * @author current_bp
 * @createTime 20170504
 */
public class PropertiesUtilTest {
    @Test
    public void getValueByKey() throws Exception {
        System.out.println(PropertiesUtil.getInstance("daletou/config").getValueByKey("analysis_num"));

    }

}