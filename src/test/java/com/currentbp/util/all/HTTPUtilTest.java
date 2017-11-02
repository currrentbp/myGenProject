package com.currentbp.util.all;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author current_bp
 * @createTime 20170407
 */
public class HTTPUtilTest {

    @Test
    public void getRequest() throws Exception {
        StringBuilder id = new StringBuilder();
        for(int i=0;i<500;i++){
            id.append("0054491f79624a048fdab9f7cb4f396d");
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        System.out.println(HTTPUtil.getRequest("http://localhost:8080/asset/getAsset",map));
    }

    @Test
    public void postRequest() throws Exception {

    }

}