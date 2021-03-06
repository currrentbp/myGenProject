package com.currentbp.Interesting.nowcoder;

import com.currentbp.util.all.Assert;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20191213
 */
public class T002 {
    /*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    @Test
    public void t1(){
        Assert.isTrue("We%20Are%20Happy".equals(replaceSpace(new StringBuffer("We Are Happy"))),"error");
    }

    public String replaceSpace(StringBuffer str) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(' ' == str.charAt(i)){
                result.append("%20");
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
