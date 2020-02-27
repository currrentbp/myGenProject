package com.currentbp.Interesting;

import com.currentbp.util.all.Assert;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author baopan
 * @createTime 2020/2/23 15:49
 */
public class CalculateTest {

    @Test
    public void t1() {

        StringUtil.printObject(calculate("((1+2)*(3*5))"));
        StringUtil.printObject(calculate("(1+((2+3)*(4*5)))"));
//        Assert.isTrue(calculate("(1+2)*(3*5)") == 45,"");

//        System.out.println((int)'0');//48

    }

    private int calculate(String content) {
        List<MyObject> calculateConten = handle(content);

        Stack<MyObject> stack = new Stack<>();


        for (int i = 0; i < calculateConten.size(); i++) {
            MyObject myObject = calculateConten.get(i);
            //不是数字
            if (!myObject.isNum) {
                if (myObject.c == '('
                        || myObject.c == '+'
                        || myObject.c == '*') {
                    stack.push(myObject);
                    continue;
                }
                if (myObject.c == ')') {
                    MyObject second = stack.pop();
                    MyObject mid = stack.pop();
                    MyObject first = stack.pop();
                    //去掉右括号
                    stack.pop();

                    MyObject myObject1 = new MyObject();
                    myObject1.isNum = true;
                    //加法
                    if (mid.c == '+') {
                        myObject1.num = first.num + second.num;
                    }
                    //乘法
                    if (mid.c == '*') {
                        myObject1.num = first.num * second.num;
                    }
                    stack.push(myObject1);
                }
            } else {
                stack.push(myObject);
            }
        }
        return stack.pop().num;
    }

    private List<MyObject> handle(String content) {
        List<MyObject> result = new ArrayList<>();
        int length = content.length();

        for (int i = 0; i < length; i++) {
            switch (content.charAt(i)) {
                case '(':
                case ')':
                case '+':
                case '*':
                    MyObject myObject = new MyObject();
                    myObject.isNum = false;
                    myObject.c = content.charAt(i);
                    result.add(myObject);
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    int size = result.size();
                    MyObject myObject1 = result.get(size - 1);
                    if (myObject1.isNum) {
                        myObject1.num = myObject1.num * 10 + ((int) content.charAt(i) - 48);
                    } else {
                        MyObject myObject2 = new MyObject();
                        myObject2.isNum = true;
                        myObject2.num = ((int) content.charAt(i) - 48);
                        result.add(myObject2);
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    class MyObject {
        boolean isNum;
        char c;
        int num;
    }
}
