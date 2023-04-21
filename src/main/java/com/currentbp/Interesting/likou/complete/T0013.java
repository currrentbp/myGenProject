package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190111
 */
public class T0013 {
    /*
    罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    //https://leetcode-cn.com/problems/roman-to-integer/

    @Test
    public void t1() {
        Assert.isTrue(romanToInt("III") == 3,"error");
        Assert.isTrue(romanToInt("IV") == 4,"error");
        Assert.isTrue(romanToInt("IX") == 9,"error");
        Assert.isTrue(romanToInt("LVIII") ==58,"error");
        Assert.isTrue(romanToInt("MCMXCIV") == 1994,"error");
        Assert.isTrue(romanToInt("D") == 500,"error");
    }

    static String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public int romanToInt(String s) {
        int result = 0;
        int flag = 0;
        while(true){
            if("".equals(s)){
                break;
            }
            if(0 == s.indexOf(str[flag])){
                result += value[flag];
            }else{
                flag++;
                continue;
            }
            s = s.substring(str[flag].length());
        }
        return result;
    }

    /*
    官网最佳答案
     */
    public int romanToInt2(String s) {
        if("".equals(s) || null == s) {
            return 0;
        }
        //transform String to char array
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            switch (chars[i]) {
                case 'I':
                    if(i + 1 == chars.length) {
                        sum += 1;
                        break;
                    } else{
                        if(chars[i + 1] == 'V' || chars[i + 1] == 'X'){
                            sum -= 1;
                        } else{
                            sum += 1;
                        }
                        break;
                    }
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i + 1 == chars.length) {
                        sum += 10;
                        break;
                    } else{
                        if(chars[i + 1] == 'L' || chars[i + 1] == 'C'){
                            sum -= 10;
                        } else {
                            sum += 10;
                        }
                        break;
                    }
                case 'L':
                    sum +=50;
                    break;
                case 'C':
                    if(i + 1 == chars.length) {
                        sum += 100;
                        break;
                    } else{
                        if(chars[i + 1] == 'D' || chars[i + 1] == 'M'){
                            sum -= 100;
                        } else{
                            sum += 100;
                        }
                        break;
                    }
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return sum;
    }
}
