package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/6/8 21:39
 */
public class T00043 {

    /*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */


    @Test
    public void t1() {
        String multiply = multiply("0", "0");
        System.out.println("===>result:" + multiply);
    }

    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || "".equals(num1.trim()) || "".equals(num2.trim())) {
            return "";
        }
        if (num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int maxLength = num1.length() + num2.length() + 1;
        int[][] point = new int[num2.length()][maxLength];

        for (int i = 0; i < num2.length(); i++) {
            int n2 = num2.charAt(num2.length() - i - 1) - 48;
            int best = 0;
            for (int j = 0; j < num1.length(); j++) {
                char c = num1.charAt(num1.length() - j - 1);
                int n1 = c - 48;
                int x = n2 * n1 + best;//两个数相乘并加上进数
                int remain = x % 10;//求余数
                best = x / 10;//求进数

                point[i][j + i] = remain;
            }
            point[i][i + num1.length()] = best;
        }

        String result = "";
        int b1 = 0;
        for (int i = 0; i < maxLength; i++) {
            int temp = b1;
            for (int j = 0; j < num2.length(); j++) {
                int now = point[j][i];
                temp = temp + now;//进位数+ 所有列的数 =》得到总和
            }

            int remain = temp % 10;//求余数，即当前位置的数字
            result = "" + remain + result;
            b1 = temp / 10;//求进位数
        }
        result = "" + b1 + result;
        int flag = 0;
        for (int i = 0; i < result.length(); i++) {
            if ('0' == result.charAt(i)) {
                flag++;
            } else {
                break;
            }
        }
        if(flag == result.length()){
            return "0";
        }

        return result.substring(flag);
    }

    /*
    官网最佳答案
     */
    public String multiply2(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(),l2 = num2.length(),l=l1+l2;
        char[] ans = new char[l];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        for(int i = l1-1;i>=0;i--){
            int c = c1[i]-'0';
            for(int j = l2-1;j>=0;--j){
                int cc = c2[j] - '0';
                ans[i+j+1] += c*cc;
            }
        }

        for(int i = l-1;i>0;--i){
            if(ans[i] > 9){
                ans[i-1] += ans[i]/10;
                ans[i] %=10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i= 0;
        for(;;i++) if(ans[i]!=0) break;
        for(;i<ans.length;i++){
            sb.append((char)(ans[i]+'0'));
        }
        return sb.toString();
    }

}
