package com.bp.daletou;

import com.bp.steam.GetPropertiesFileInfo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 大乐透测试类
 *
 * @author current_bp
 * @createTime 20170503
 */
public class DaletouTest {

    @Test
    public void config(){
        System.out.println(GetPropertiesFileInfo.getProperties("src//main//resources//daletou//config.properties")
                .getProperty("analysis_num"));
    }

}