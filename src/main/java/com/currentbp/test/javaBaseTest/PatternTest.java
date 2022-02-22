package com.currentbp.test.javaBaseTest;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author baopan
 * @createTime 20211207
 */
public class PatternTest {

    Pattern pattern1 = Pattern.compile("^[^~@#%^™®&№℡‰¢∮※<>∏¥§℅€℃£℉$？?\\[\\]ăᝰ]+$");
    Pattern pattern2 = Pattern.compile("^[A-Za-z0-9\\u4e00-\\u9fa5]+$");

    @Test
    public void t1() {
        String str = ".***啊1123呵呵大   //";
        boolean matches = pattern1.matcher(str).matches() && pattern2.matcher(str).matches();
        System.out.println(matches);
    }
}
