package com.currentbp.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author current_bp
 * @createTime 20170913
 */
public class ObjectTest {
    private final static Logger logger = LoggerFactory.getLogger(ObjectTest.class);

    @Test
    public void t1(){
        String source = "{\"name\":\"baopan\",\"desc\":\"baopan desc\"}";
        JSONObject json = JSON.parseObject(source);
        String name = json.getString("name");
        String desc = json.getString("desc");
        String sss = json.getString("sss");
        System.out.println(name+" "+desc+" ==>"+sss);
    }

    /**
     * 关于复杂赋值问题
     */
    @Test
    public void objectRevalue() {
        Integer i = 1;
        Integer j = 2;
        Integer k = 3;
        k = j = i;
        logger.info("===>k:" + k + " j:" + j + " i:" + i);
    }
}
