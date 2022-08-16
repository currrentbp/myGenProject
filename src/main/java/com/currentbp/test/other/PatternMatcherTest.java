package com.currentbp.test.other;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 关于匹配的测试
 *
 * @author current_bp
 * @createTime 20170525
 */
public class PatternMatcherTest {

    @Test
    public void koPattern(){
        String ko1 = "123장";
        String p1 = "장";
        Pattern pattern = Pattern.compile("[0-9]+장");
        System.out.println(pattern.matcher(ko1).find());
    }

    @Test
    public void isPhone() {
        Pattern pattern = Pattern.compile("^1[3|4|5|8]\\d{9}$");
        Matcher matcher = pattern.matcher("15711310502");
        boolean rs = matcher.matches();
        System.out.println(rs);
    }

    @Test
    public void wenhaoTest() {
        Pattern pattern = Pattern.compile("industr(?:y|ies)");
        Matcher matcher = pattern.matcher("industry");
        Matcher matcher2 = pattern.matcher("industries");
        Matcher matcher3 = pattern.matcher("industr1ies");

        boolean rs = matcher.matches();
        boolean rs2 = matcher2.matches();
        boolean rs3 = matcher3.matches();
        System.out.println("1:" + rs + " 2:" + rs2 + " 3:" + rs3);

        String regEx = "(?=[\\s\\S]*?)(\\[smiley1=[0-9]+\\])(?=[\\s\\S]*?)";
        String str = "adfasdf[smiley1=4]kk [smiley=1]   mko[smiley=2],sdfaasdfa fd";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(str);
        while (mat.find()) {
            System.out.println(mat.group(1));
        }
    }

    @Test
    public void wenhaoDenghaoTest() {
        Pattern pattern = Pattern.compile("Windows(?=9|98|NT|2000)");
        Matcher matcher = pattern.matcher("Windows");
        Matcher matcher2 = pattern.matcher("Windows3.1");
        boolean rs = matcher.matches();
        boolean rs2 = matcher2.matches();
        System.out.println("1:" + rs + " 2:" + rs2);
    }

    @Test
    public void matchXinghao() {
        Pattern pattern = Pattern.compile(".*");
        Matcher matcher = pattern.matcher("baopan");
        System.out.println("result:" + matcher.matches());
    }

    @Test
    public void matchA() {
        String reg = "<a>(.*)</a>";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("123<a>123</a>123");
        while (matcher.find()) {
            System.out.println("find:" + matcher.group());
        }
    }

    @Test
    public void matchNum() {
        //然后\1表示重复开始的(\w)中的内容.
        Pattern pattern = Pattern.compile("(\\wb)a\\1");
        Matcher matcher = pattern.matcher("wbawb");
        assert matcher.matches();
        System.out.println("===>result:" + matcher.group());

        Pattern pattern2 = Pattern.compile("\\b(\\w)?k(\\w)\\w?.*");
        Matcher matcher2 = pattern2.matcher("dkas ");
        assert matcher2.matches();
        System.out.println("===>result:" + matcher2.group());
    }

    @Test
    public void matchW() {
        Pattern pattern = Pattern.compile("\\bmy.*");
        Matcher matcher = pattern.matcher("my a");
        assert matcher.matches();
    }

    @Test
    public void getGroup(){
        Pattern pattern = Pattern.compile("([0-9]+)");
        Matcher matcher = pattern.matcher("订单号12334435464567");
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
    }

}
