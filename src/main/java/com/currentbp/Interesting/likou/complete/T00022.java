package com.currentbp.Interesting.likou.complete;


import com.alibaba.fastjson.JSON;
import com.currentbp.bean.copy.First;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 20190213
 */
public class T00022 {
    /*
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
     */
    //https://leetcode-cn.com/problems/generate-parentheses/

    @Test
    public void t1() {
        ListUtil.printList(generateParenthesis(3));
    }

    public static char left = '(';
    public static char right = ')';


    public List<String> generateParenthesis2(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        //第二种策略，使用树形结构不用递归
        return result;
    }

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        int leftCount = 0;
        int rightCount = 0;
        List<String> result = new ArrayList<>();
        result.add("");
        g1(leftCount, rightCount, n, result, 0);

        return result;
    }

    private void g1(int leftCount, int rightCount, int sum, List<String> result, int index) {
        String source = result.get(index);
        if (leftCount == sum && rightCount == sum) {
            return;
        }

        if (leftCount == sum && leftCount > rightCount) {
            source += right;
            result.set(index, source);
            g1(leftCount, rightCount + 1, sum, result, index);
            return;
        }

        //左括号多余右括号，表示下一个可以添加左括号也可以添加右括号
        if (sum > leftCount && sum > rightCount) {
            if (leftCount > rightCount) {
                String temp1 = source;
                temp1 += left;
                result.set(index, temp1);
                g1(leftCount + 1, rightCount, sum, result, index);
                String temp2 = source;
                temp2 += right;
                result.add(temp2);
                int index2 = result.size();
                g1(leftCount, rightCount + 1, sum, result, index2 - 1);
            } else if (leftCount == rightCount) {
                source += left;
                result.set(index, source);
                g1(leftCount + 1, rightCount, sum, result, index);
            } else {
                return;
            }
        }
    }

    /**
     * 官网最佳答案
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList();
        if(n < 1){
            return list;
        }
        if(n == 1){
            list.add("()");
            return list;
        }

        char[] chars = new char[n * 2];

        chars[0] = '(';

        int index = 1;

        int s = 1,e = 0;

        solo(chars,list,index,s,e,n);

        return list;

    }

    private void solo(char[] chars,List list,int index,int s,int e,int n){
        if(e > s){
            return;
        }else{
            if(index == chars.length - 1){
                if(s == e + 1){
                    chars[index] = ')';
                    list.add(String.valueOf(chars));
                }
                return;
            }
            if(s < n){
                chars[index] = '(';
                solo(chars,list,index+1,s+1,e,n);
            }
            chars[index] = ')';
            solo(chars,list,index+1,s,e+1,n);
        }
    }
}
