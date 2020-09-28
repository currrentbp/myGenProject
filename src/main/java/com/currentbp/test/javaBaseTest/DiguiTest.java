package com.currentbp.test.javaBaseTest;

import org.junit.Test;

/**
 * 用于测试递归堆栈溢出问题
 *
 * @author current_bp
 * @createTime 20170523
 */
public class DiguiTest {

    /*
    测试目的：
    1、递归时，什么时候会发生溢出
    2、练习使用顺推算法（通过已知结果，算出未知的目的）
    结论：
    1、1W时还能正常工作（不保证数据是否正常，只保证不会出异常），在10W时就报溢出错误
    2、顺推算法能完美的解决这个溢出问题，（可能需要解决的业务问题不少）
     */

    @Test
    public void digui() {
        int i = getResult(100000);//10W的时候就已经开始StackOverflowError
        System.out.println("===>i:" + i);
    }

    private int getResult(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getResult(n - 1);
        }
    }

    @Test
    public void shuntuiTest() {
        int i = getResult2(100000);
        System.out.println("===>i:" + i);
    }

    private int getResult2(int n) {
        int result = 0;

        for (int i = 0; i <= n; i++) {
            result = result + i;
        }

        return result;
    }

}
