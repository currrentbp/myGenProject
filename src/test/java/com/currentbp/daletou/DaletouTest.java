package com.currentbp.daletou;

import com.currentbp.steam.GetPropertiesFileInfo;
import org.junit.Test;

/**
 * 大乐透测试类
 *
 * @author current_bp
 * @createTime 20170503
 */
public class DaletouTest {

    @Test
    public void initAnalysis() throws Exception {
        Daletou daletou = new Daletou();
//        daletou.initReadDaletouHistory();
//        daletou.initAnalysis();
    }

    @Test
    public void initReadDaletouHistory() throws Exception {
        Daletou daletou = new Daletou();
//        daletou.initReadDaletouHistory();
    }

    @Test
    public void config(){
        System.out.println(GetPropertiesFileInfo.getProperties("src//main//resources//daletou//config.properties")
                .getProperty("analysis_num"));
    }

    @Test
    public void predictDaletou() throws Exception {
        Daletou daletou = new Daletou();
//        daletou.predictDaletou();
    }


}