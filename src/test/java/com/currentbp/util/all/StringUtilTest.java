package com.currentbp.util.all;

import org.junit.Test;

/**
 * Created by issuser on 2017/5/25.
 */
public class StringUtilTest {
    @Test
    public void getHumpFormat(){
        System.out.println(StringUtil.getHumpFormat("bp"));
        System.out.println(StringUtil.getHumpFormat(null));
        System.out.println(StringUtil.getHumpFormat("b"));
        System.out.println(StringUtil.getHumpFormat("bp_1"));
        System.out.println(StringUtil.getHumpFormat("bp_C"));
        System.out.println(StringUtil.getHumpFormat("bp_f"));
        System.out.println(StringUtil.getHumpFormat("bp_i_k_qq"));
        System.out.println(StringUtil.getHumpFormat("Bp_i_k_qq"));
    }

    @Test
    public void deleteLast() throws Exception {

    }

    @Test
    public void getStringWithOutSome() throws Exception {

    }

    @Test
    public void getStringWithOutSome1() throws Exception {

    }

    @Test
    public void getStringWithOutSome2() throws Exception {

    }

    @Test
    public void fillBySome() throws Exception {

    }

    @Test
    public void fillBySome1() throws Exception {

    }

    @Test
    public void fillBySome2() throws Exception {

    }

    @Test
    public void fillBySome3() throws Exception {

    }

    @Test
    public void getCaptureName() throws Exception {

    }

    @Test
    public void getSplitString() throws Exception {

    }

    @Test
    public void insertSomethingToWhere() throws Exception {

    }

    @Test
    public void stringToList() throws Exception {

    }

    @Test
    public void stringToList1() throws Exception {

    }

    @Test
    public void letter2Int() throws Exception {

    }

    @Test
    public void int2Letter() throws Exception {

    }

    @Test
    public void getALabel() throws Exception {
        String source = "<em>123</em><em>456</em>";
        System.out.println(StringUtil.getLabelContent(source, "em"));
    }


}