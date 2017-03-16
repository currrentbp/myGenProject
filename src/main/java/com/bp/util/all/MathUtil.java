package com.bp.util.all;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 将两个长的数字相乘
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multTwoLongNum(String num1, String num2) {
        String result = "0";
        if (CheckUtil.isEmpty(num1) && CheckUtil.isEmpty(num2)) {
            return result;
        }
        String shortNum = num1.length() < num2.length() ? num1 : num2;
        String longNum = num1.length() < num2.length() ? num2 : num1;

        List<String> allMult = new ArrayList<String>();
        //长的数字的小数点位置
        int index = getPointLocation(longNum);
        //整理后的长数字
        String longNum2 = getRemovePointNum(longNum);

        //1、先将一个数字分解成最简单的数，可以是小数，
        //key是该短的数的值，value是该短值的小数点的位置，
        Map<String, Integer> shortNumMap = splitTheNum(shortNum);
        //2、将一个简单的数和复杂的数相乘
        allMult = multAll(longNum2, index, shortNumMap);
        //3、将这些乘的结果集相加
        for (String num : allMult) {
            result = addTwoLongNum(num, result);
        }
        return result;
    }

    /**
     * 将数字相乘得出一些需要加的数字
     *
     * @param longNum     长的数字
     * @param pointIndex  长值的小数点位置
     * @param shortNumMap 短数的拆分集合
     * @return 短数的分片乘积
     */
    private static List<String> multAll(String longNum, int pointIndex, Map<String, Integer> shortNumMap) {
        List<String> result = new ArrayList<String>();

        //TODO NOT WORK
        return result;
    }


    /**
     * 获取一个去处小数点的数，就是将该数扩大或者缩小10的整数倍
     *
     * @param num 数字
     * @return 结果
     */
    private static String getRemovePointNum(String num) {
        String result = "0";
        //TODO NOT WORK
        return result;
    }

    /**
     * 获取小数点的位置
     *
     * @param num 数字
     * @return 小数点的位置
     */
    private static int getPointLocation(String num) {
        int result = 0;

        //TODO NOT WORK

        return result;
    }

    /**
     * 将一个值分割：key是该短的数的值，value是该短值的小数点的位置，
     *
     * @param num 数字
     * @return 分割后的值集合
     */
    private static Map<String, Integer> splitTheNum(String num) {
        Map<String, Integer> shortNumMap = new HashMap<String, Integer>();
        num = getNumNoTailZeroAndHeadZero(num);

        //TODO not work
        boolean containsPoint = num.contains(".");
        String tail = num.substring(num.indexOf(".")+1);
        String head = num.substring(0, num.indexOf("."));


        return shortNumMap;
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
        result = getNumNoTailZeroAndHeadZero(result);
        return result;
    }

    /**
     * 获取没有后面无用的0的数字
     *
     * @param num 数字
     * @return 结果
     */
    private static String getNumNoTailZeroAndHeadZero(String num) {
        String result = "0";



        String head = num.substring(0, num.indexOf("."));
        String sourceHead = head;
        for (int i = 0; i < sourceHead.length(); i++) {
            if ("0".equals("" + head.charAt(i))) {
                head = sourceHead.substring(i);
            } else {
                break;
            }
        }
        //没有小数点
        boolean containsPoint = num.contains(".");
        if(!containsPoint){
            return result;
        }

        String tail = num.substring(num.indexOf(".")+1);
        if (CheckUtil.isEmpty(tail)) {
            return num;
        }
        String sourceTail = tail;
        for (int i = sourceTail.length() - 1; i >= 0; i--) {
            if ("0".equals("" + tail.charAt(i))) {
                tail = sourceTail.substring(0, i);
            } else {
                break;
            }
        }


        head = CheckUtil.isEmpty(head) ? "0" : head;

        result = head + (CheckUtil.isEmpty(tail) ? "" : "." + tail);
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
        //整理数字
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
        System.out.println("9.9+1.1 = " + MathUtil.addTwoLongNum("9.9", "1.1"));
        System.out.println("9999999999.9+1.11111 = " + MathUtil.addTwoLongNum("9999999999.9", "1.11111"));
        System.out.println("1234567890+987654321 = " + MathUtil.addTwoLongNum("1234567890", "987654321"));

    }
}
