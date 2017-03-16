package com.bp.util.all;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数学函数
 *
 * @author current_bp
 * @createTime 20160519
 */
public class MathUtil {

    /**
     * 将long类型的数据除以2
     *
     * @param divideNum
     * @return
     */
    public static long divideTwo(long divideNum) {
        return divideNum >> 1;
    }

    /**
     * 将int类型的数据除以2
     *
     * @param divideNum
     * @return
     */
    public static int divideTwo(int divideNum) {
        return divideNum >> 1;
    }

    /**
     * 将long类型的数据乘以2
     *
     * @param multTwo
     * @return
     */
    public static long multTwo(long multTwo) {
        return multTwo << 1;
    }

    /**
     * 将int类型的数据乘以2
     *
     * @param multNum
     * @return
     */
    public static int multTwo(int multNum) {
        return multNum << 1;
    }

    /**
     * 计算两点之间距离（默认到原点距离）
     *
     * @param x1
     * @param y1
     * @return
     */
    public static float distanceFromTwoPlace(float x1, float y1) {
        return distanceFromTwoPlace(0, 0, x1, y1);
    }

    /**
     * 计算两点之间距离
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static float distanceFromTwoPlace(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    // submultiple约数，因数;

    /**
     * 求出一个数的所有的约数包括（1，self）
     *
     * @param num
     * @return
     */
    public List<Integer> allSubmultiple(int num) {
        List<Integer> result = new ArrayList<Integer>();
        if (0 >= num) {
            throw new RuntimeException("求所有的约数时，不允许数字为负数或零！");
        }

        // 添加最小约数
        result.add(1);

        if (2 <= MathUtil.divideTwo(num)) {
            for (int i = 2; i <= MathUtil.divideTwo(num); i++) {
                if (0 == num % i) {
                    result.add(i);
                }
            }
        }

        // 添加最大约数
        result.add(num);

        return result;
    }

    /**
     * 公约数(Common divisor)
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int maxCommonDivisor(int num1, int num2) {
        int result = 1;

        if (num1 <= 0 || num2 <= 0) {
            throw new RuntimeException("求最大公约数，不允许数字为负数或零！");
        }

        int maxNum = num1 < num2 ? num2 : num1;

        for (int i = 1; i <= maxNum; i++) {
            if (0 == num1 % i && 0 == num2 % i) {
                result = i;
            }
        }

        return result;
    }

    @Test
    public void addTwoLongNum(){
        //计算两个超长的数字相加的结果
        System.out.println("9.9+1.1 = "+MathUtil.addTwoLongNum("9.9", "1.1"));
        System.out.println("9999999999.9+1.11111 = "+MathUtil.addTwoLongNum("9999999999.9", "1.11111"));
        System.out.println("1234567890+987654321 = "+MathUtil.addTwoLongNum("1234567890", "987654321"));
    }

    /**
     * 两个长的数字相加
     *
     * @param num1 被数
     * @param num2 加数
     * @return 两个长的数字相加
     */
    public static String addTwoLongNum(String num1, String num2) {
        String result = "0";
        if (CheckUtil.isEmpty(num1) && CheckUtil.isEmpty(num2)) {
            return result;
        }
        if (!num1.contains(".")) {
            num1 = num1 + ".0";
        }
        if (!num2.contains(".")) {
            num2 = num2 + ".0";
        }
        String num1BeforePoint = num1.split("\\.")[0];
        String num1AfterPoint = num1.split("\\.")[1];
        String num2BeforePoint = num2.split("\\.")[0];
        String num2AfterPoint = num2.split("\\.")[1];

        String afterPointResult = getAddResult(num1AfterPoint, num2AfterPoint, false);
        //判断小数点后半段是否进位
        String first = afterPointResult.substring(0, 1);
        String beforePointResult = getAddResult(getAddResult(num1BeforePoint, num2BeforePoint, true), first, true);

        result = beforePointResult + "." + afterPointResult.substring(1);
        return result;
    }

    /**
     * 计算数字的前半段或者后半段的结果,
     * 如果是小数点后半段，则判断第一位是否为0，
     * 如果为0，则不需要进位，否则第一位是进位数
     *
     * @param num1          数字1
     * @param num2          数字2
     * @param isBeforePoint 是否是小数点前半段
     * @return 结果
     */
    private static String getAddResult(String num1, String num2, boolean isBeforePoint) {
        StringBuilder result = new StringBuilder("");
        int size = num1.length() > num2.length() ? num1.length() : num2.length();
        int[] result1 = new int[size + 1];
        int[] n1 = new int[size + 1];
        int[] n2 = new int[size + 1];

        if (isBeforePoint) {//小数点前半段
            for (int i = 0; i < num1.length(); i++) {
                n1[size - i] = Integer.parseInt("" + num1.charAt(num1.length() - i - 1));
            }
            for (int i = 0; i < num2.length(); i++) {
                n2[size - i] = Integer.parseInt("" + num2.charAt(num2.length() - i - 1));
            }

            int stay1 = 0;
            for (int i = size; i >= 0; i--) {
                int carry = (n1[i] + n2[i] + stay1) / 10;//进位
                int stay = (n1[i] + n2[i] + stay1) % 10;//余数
                result1[i] = stay;

                stay1 = carry;
            }

            boolean flag = true;
            for (int i = 0; i < result1.length; i++) {
                //去除前面的0
                if (result1[i] == 0 && flag) {
                    continue;
                } else {
                    flag = false;
                }
                result.append(result1[i]);
            }
        } else {//小数点后半段
            for (int i = 0; i < num1.length(); i++) {
                n1[i + 1] = Integer.parseInt("" + num1.charAt(i));
            }
            for (int i = 0; i < num2.length(); i++) {
                n2[i + 1] = Integer.parseInt("" + num2.charAt(i));
            }

            int stay1 = 0;
            for (int i = size; i >= 0; i--) {
                int carry = (n1[i] + n2[i] + stay1) / 10;//进位
                int stay = (n1[i] + n2[i] + stay1) % 10;//余数
                result1[i] = stay;

                stay1 = carry;
            }

            for (int i = 0; i < result1.length; i++) {
                result.append(result1[i]);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

        // //求出一个数的所有约数
        MathUtil mu = new MathUtil();
        // System.out.println(mu.allSubmultiple(124));

        // //求最大公约数
        // System.out.println(MathUtil.maxCommonDivisor(8, 4));

        // //与原点之间的距离，或者两点之间的距离
        // System.out.println(MathUtil.distanceFromTwoPlace(1, 1));

        // System.out.println(MathUtil.divideTwo(5));
        // System.out.println(MathUtil.multTwo(5));
        // System.out.println(MathUtil.divideTwo(5L));
        // System.out.println(MathUtil.multTwo(5L));

        //计算两个超长的数字相加的结果
        System.out.println("9.9+1.1 = "+MathUtil.addTwoLongNum("9.9", "1.1"));
        System.out.println("9999999999.9+1.11111 = "+MathUtil.addTwoLongNum("9999999999.9", "1.11111"));
        System.out.println("1234567890+987654321 = "+MathUtil.addTwoLongNum("1234567890", "987654321"));

    }
}
