package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 替换空格
 *
 * @author baopan
 * @createTime 2020/8/18 21:09
 */
public class ReplaceEmpty {

    @Test
    public void t1(){
        StringUtil.printObject(replaceEmpty("how are you"));
    }

    private String replaceEmpty(String source) {
        if (null == source || source.length() == 0) {
            return source;
        }
        String result = "";
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == ' ') {
                result += "%20";
                continue;
            }
            result += source.charAt(i);
        }
        return result;
    }
}
