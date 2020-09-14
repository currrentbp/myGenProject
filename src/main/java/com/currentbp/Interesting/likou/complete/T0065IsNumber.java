package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/9/14 10:28
 */
public class T0065IsNumber {
    /*
验证给定的字符串是否可以解释为十进制数字。
例如:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false
说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
这里给出一份可能存在于有效十进制数字中的字符列表：
数字 0-9
指数 - "e"
正/负号 - "+"/"-"
小数点 - "."
当然，在输入中，这些字符的上下文也很重要。
     */
    @Test
    public void t1() {
        Assert.isTrue(isNumber("6+1"), "error");
//        Assert.isTrue(isNumber("1."), "error");
//        Assert.isTrue(isNumber("."), "error");
//        Assert.isTrue(isNumber(".1"),"error");
//        Assert.isTrue(isNumber("1"),"error");
//        Assert.isTrue(isNumber(" 0.1"),"error");
//        Assert.isTrue(isNumber("abc"),"error");
//        Assert.isTrue(isNumber("1 a"),"error");
//        Assert.isTrue(isNumber("2e10"),"error");
//        Assert.isTrue(isNumber(" -90e3  "),"error");
//        Assert.isTrue(isNumber("1e"),"error");
//        Assert.isTrue(isNumber("e3"),"error");
//        Assert.isTrue(isNumber("6e-1"),"error");
//        Assert.isTrue(isNumber("99e2.5"),"error");
//        Assert.isTrue(isNumber("53.5e93"),"error");
//        Assert.isTrue(isNumber("--6"),"error");
//        Assert.isTrue(isNumber("-+3"),"error");
//        Assert.isTrue(isNumber("95a54e53"),"error");
    }

    public boolean isNumber(String s) {
        if (null == s || "".equals(s.trim())) {
            return false;
        }
        s = s.trim();
        boolean hasSymbol = isSymbol(s.charAt(0));//是否已经存在符号了
        boolean hasPoint = false;//是否存在小数点了
        boolean numIsStart = false;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!isValidChar(currentChar)) {//字符不合法
                return false;
            }
            if (hasSymbol && i >= 1 && isSymbol(currentChar)) {//表示第一位已经是符号位了，后面还有符号
                return false;
            }
            if (numIsStart && isSymbol(currentChar)) {
                return false;
            }
            if (isNum(currentChar) && !numIsStart) {//是数字，而且之前没有数字，表明开始梳理数字部分了
                numIsStart = true;
            }
            if (isE(currentChar)) {
                if (!numIsStart) {//不是数字开始的
                    return false;
                }
                if (s.length() - 1 == i) {//表示e在最后一个位置，不是浮点数字
                    return false;
                }
                return isFloat(s.substring(i + 1));
            }
            if ('.' == currentChar) {//当前位置是小数点
                if (hasPoint) {//已经存在小数点了
                    return false;
                } else {
                    hasPoint = true;
                    if (!((i - 1 >= 0 && isNum(s.charAt(i - 1)))
                            || (i + 1 < s.length() && isNum(s.charAt(i + 1))))) {//小数点前有数字或者小数点后面有数字
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * 浮点判断，只判断e后面的部分
     */
    private boolean isFloat(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        char firstChar = s.charAt(0);
        int index = isSymbol(firstChar) ? 1 : 0;
        if (index >= s.length()) {
            return false;
        }
        for (; index < s.length(); index++) {
            if (!isNum(s.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        boolean result = false;
        if (isSymbol(c) || isE(c) || c == '.' || isNum(c)) {
            result = true;
        }
        return result;
    }

    private boolean isE(char c) {
        return c == 'e' || c == 'E';
    }

    private boolean isSymbol(char c) {
        return c == '+' || c == '-';
    }

    private boolean isNum(char c) {
        boolean result = false;
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                result = true;
                break;
            default:
                break;
        }
        return result;
    }
}
