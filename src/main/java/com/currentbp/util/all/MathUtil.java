package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 数学函数
 *
 * @author current_bp
 * @createTime 20160519
 */
public class MathUtil {
    private final static Logger logger = LoggerFactory.getLogger(MathUtil.class);

    /**
     * 组合:Cmn
     *
     * @return 所有可能的组合结果
     */
    public static List<String> combination(int[] source, int m) {
        Assert.isTrue(null != source && m > 0 && source.length >= m, "公式有错误，0<m<=n");
        final int sl = source.length;
        int[] tags = new int[sl];
        //初始化排位
        for (int i = 0; i < m; i++) {
            tags[sl - i - 1] = 1;
        }
        logger.info("===>" + JSON.toJSONString(tags));
        int index = sl - m;
        logger.info("===>index:" + index);
        List<String> result = new ArrayList<String>();
        result.add(printCombination(source, tags));
        while (true) {
            int left = canMove2Left(tags, index);
            if (-1 != left) {//能左移
                //1：先左移,2:再打印
                tags[left] = 1;
                tags[index] = 0;//左移
                index = left;//标志位左移
                result.add(printCombination(source, tags));
            } else {//标志位不能左移时，考虑是否存在下一个标志位，如果存在下一个，则将标志位移动，否则直接跳出
                int right = hasNextRight(tags, index);
                if (-1 != right) {//标志位能找到下一个
                    index = right;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 是否存在下一个可以标记的位置
     *
     * @param tags  标记
     * @param index 起始位置
     * @return 下一个可以标记的位置
     */
    private static int hasNextRight(int[] tags, int index) {
        int result = -1;
        if (tags.length - index >= 1) {
            for (int i = index + 1; i < tags.length; i++) {
                if (tags[index] == tags[i]) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 打印单个符合要求的组合
     *
     * @param source 源
     * @param tags   标记位
     * @return 组合
     */
    private static String printCombination(int[] source, int[] tags) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < tags.length; i++) {
            if (1 == tags[i]) {
                sb.append(source[i]);
            }
        }
        logger.info("===>" + sb.toString());
        return sb.toString();
    }

    /**
     * 能左移
     *
     * @param tags  0,1的组合
     * @param index 起始位置
     * @return 移动到左边的第一个位置
     */
    private static int canMove2Left(int[] tags, int index) {
        int result = -1;
        if (index >= 1) {
            for (int i = index - 1; i >= 0; i--) {
                if ((tags[i] ^ tags[index]) == 1) {//异或为1表示可以移动
                    return i;
                }
            }
        }

        return result;
    }

    /**
     * 将long类型的数据除以2
     *
     * @param divideNum 数字
     * @return 结果
     */
    public static long divideTwo(long divideNum) {
        return divideNum >> 1;
    }

    /**
     * 将int类型的数据除以2
     *
     * @param divideNum 数字
     * @return 结果
     */
    public static int divideTwo(int divideNum) {
        return divideNum >> 1;
    }

    /**
     * 将long类型的数据乘以2
     *
     * @param multTwo 数字
     * @return 结果
     */
    public static long multTwo(long multTwo) {
        return multTwo << 1;
    }

    /**
     * 将int类型的数据乘以2
     *
     * @param multNum 数字
     * @return 结果
     */
    public static int multTwo(int multNum) {
        return multNum << 1;
    }

    /**
     * 计算两点之间距离（默认到原点距离）
     *
     * @param x1 x1
     * @param y1 y1
     * @return 距离
     */
    public static float distanceFromTwoPlace(float x1, float y1) {
        return distanceFromTwoPlace(0, 0, x1, y1);
    }

    /**
     * 计算两点之间距离
     *
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @return 距离
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
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
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
     * 将两个长值的数字相互减法
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
     */
    public static String subtractionTwoLongNum(String num1, String num2) {
        String result = "0";
        return result;
    }

    /**
     * 将两个长的数字相乘
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
     */
    public static String multTwoLongNum(String num1, String num2) {
        boolean f1 = isNegativeNum(num1);
        boolean f2 = isNegativeNum(num2);
        String pre = f1 ^ f2 ? "-" : "";
        num1 = num1.contains("-") || num1.contains("+") ? num1.substring(1) : num1;
        num2 = num2.contains("-") || num2.contains("+") ? num2.substring(1) : num2;

        String result = "0";
        if (CheckUtil.isEmpty(num1) && CheckUtil.isEmpty(num2)) {
            return result;
        }
        num1 = getNumNoTailZeroAndHeadZero(num1);
        num2 = getNumNoTailZeroAndHeadZero(num2);
        String shortNum = num1.length() < num2.length() ? num1 : num2;
        String longNum = num1.length() < num2.length() ? num2 : num1;

        List<String> allMult = new ArrayList<String>();
        //长的数字的小数点位置
        int index = getPointLocation(longNum);
        //整理后的长数字
        String longNum2 = getRemovePointNum(longNum);

        //1、先将一个数字分解成最简单的数，可以是小数，
        //key是该短的数的值，value是该短值的小数点的位置，
        List<String[]> shortNumMap = splitTheNum(shortNum);
        //2、将一个简单的数和复杂的数相乘
        allMult = multAll(longNum2, index, shortNumMap);
        //3、将这些乘的结果集相加
        for (String num : allMult) {
            result = addTwoLongNum(num, result);
        }
        return pre + result;
    }

    /**
     * 是否是负数
     *
     * @param num 数字
     * @return 是否是负数
     */
    private static boolean isNegativeNum(String num) {
        return num.contains("-");
    }

    /**
     * 将数字相乘得出一些需要加的数字
     *
     * @param longNum      长的数字
     * @param pointIndex   长值的小数点位置
     * @param shortNumList 短数的拆分集合
     * @return 短数的分片乘积
     */
    private static List<String> multAll(String longNum, int pointIndex, List<String[]> shortNumList) {
        List<String> result = new ArrayList<String>();

        for (String[] shortNum : shortNumList) {
            String num = multEach(longNum, pointIndex, shortNum[0], Integer.parseInt(shortNum[1]));
            num = getNumNoTailZeroAndHeadZero(num);
            result.add(num);
        }
        return result;
    }


    /**
     * 计算结果
     *
     * @param longNum       长值
     * @param pointIndex    长值的小数点
     * @param shortNum      短值
     * @param shortNumPoint 短值的小数点位置
     * @return 结果
     */
    private static String multEach(String longNum, int pointIndex, String shortNum, int shortNumPoint) {
        String result = "";
        int point = pointIndex + shortNumPoint;
        int carry = 0;
        for (int i = longNum.length() - 1; i >= 0; i--) {
            int mult1 = Integer.parseInt("" + longNum.charAt(i));
            int stay = (mult1 * Integer.parseInt(shortNum) + carry) % 10;
            carry = (mult1 * Integer.parseInt(shortNum) + carry) / 10;
            result = stay + result;
        }

        result = carry + result;
        if (point == 0) {

        } else if (point > 0) {
            String temp = "";
            for (int i = 0; i < point; i++) {
                temp = temp + "0";
            }
            result = result + temp;
        } else {
            String head = result.substring(0, result.length() + point);
            String tail = result.substring(result.length() + point);
            result = head + "." + tail;
        }
        result = getNumNoTailZeroAndHeadZero(result);
        return result;
    }


    /**
     * 获取一个去处小数点的数，就是将该数扩大或者缩小10的整数倍
     *
     * @param num 数字
     * @return 结果
     */
    private static String getRemovePointNum(String num) {
        String result = num;
        if (!num.contains(".")) {
            return result;
        }
        result = getNumNoTailZeroAndHeadZero(num.replace(".", ""));
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
        if (!num.contains(".")) {
            return result;
        }
        result = num.length() - num.indexOf(".") - 1;
        return result * -1;
    }

    /**
     * 将一个值分割：key是该短的数的值，value是该短值的小数点的位置，
     *
     * @param num 数字
     * @return 分割后的值集合
     */
    private static List<String[]> splitTheNum(String num) {
        List<String[]> shortNumList = new ArrayList<String[]>();
        num = getNumNoTailZeroAndHeadZero(num);

        boolean containsPoint = num.contains(".");
        if (!containsPoint) {//没有小数点
            for (int i = 0; i < num.length(); i++) {
                String c = "" + num.charAt(num.length() - 1 - i);
                String[] element = new String[2];
                element[0] = c;
                element[1] = "" + i;
                shortNumList.add(element);
            }
        } else {//存在小数点
            String head = num.substring(0, num.indexOf("."));
            String tail = num.substring(num.indexOf(".") + 1);

            if (!CheckUtil.isEmpty(head)) {
                for (int i = head.length() - 1; i >= 0; i--) {
                    String[] element = new String[2];
                    element[0] = "" + head.charAt(i);
                    element[1] = "" + (head.length() - i - 1);
                    shortNumList.add(element);
                }
            }
            if (!CheckUtil.isEmpty(tail)) {
                for (int i = 0; i < tail.length(); i++) {
                    String[] element = new String[2];
                    element[0] = "" + tail.charAt(i);
                    element[1] = "" + ((i + 1) * -1);
                    shortNumList.add(element);
                }
            }

        }
        return shortNumList;
    }

    /**
     * 两个长的数字相减
     *
     * @param num1 被减数
     * @param num2 减数
     * @return 结果
     */
    public static String subTwoLonNum(String num1, String num2) {
        String result = "0";
        //如果两个数字是一正一负，则相当于加法
        boolean f1 = isNegativeNum(num1);
        boolean f2 = isNegativeNum(num2);
        if (f1 ^ f2) {//一正一负
            String pre = num1.contains("-") ? "-" : "";//第一个数决定是加法还是减法
            num1 = num1.contains("-") || num1.contains("+") ? num1.substring(1) : num1;
            num2 = num2.contains("-") || num2.contains("+") ? num2.substring(1) : num2;
            return pre + addTwoLongNum(num1, num2);
        }

        //两个数字的符号
        String n1Pre = num1.contains("-") || num1.contains("+") ? num1.substring(0, 1) : "+";
        String n2Pre = num2.contains("-") || num2.contains("+") ? num2.substring(0, 1) : "+";
        num1 = num1.contains("-") || num1.contains("+") ? num1.substring(1) : num1;
        num2 = num2.contains("-") || num2.contains("+") ? num2.substring(1) : num2;

        //1、判断两个数的正值的大小:0:等于，1：大于，-1：小于
        int flag = compareTwoLongNum(num1, num2);
        //2、两个数相减
        if (flag == 0) {
            return result;
        }
        //决定符号//TODO 有问题
        String pre = getPreBy2LongNumMult(num1, num2, flag);


        return result;
    }

    /**
     * @param num1 第一个数
     * @param num2
     * @param flag
     * @return
     */
    private static String getPreBy2LongNumMult(String num1, String num2, int flag) {
        String pre = "+";


        return pre;
    }


    /**
     * 比较两个数字的大小
     *
     * @param num1 第一个正数
     * @param num2 第二个正数
     * @return 0:等于，1：大于，-1：小于
     */
    private static int compareTwoLongNum(String num1, String num2) {
        String num1_1 = getNumNoTailZeroAndHeadZero(num1);
        String num2_1 = getNumNoTailZeroAndHeadZero(num2);

        num1_1 = num1_1.contains(".") ? num1_1 : num1_1 + ".0";
        num2_1 = num2_1.contains(".") ? num2_1 : num2_1 + ".0";

        String num1Head = num1_1.substring(0, num1_1.indexOf("."));
        String num2Head = num2_1.substring(0, num2_1.indexOf("."));
        String num1Tail = num1_1.substring(num1_1.indexOf(".") + 1);
        String num2Tail = num2_1.substring(num2_1.indexOf(".") + 1);

        if (num1Head.length() > num2Head.length()) {//第一个数字的小数点前半段长度大于第二个
            return 1;
        } else if (num1Head.length() < num2Head.length()) {//第一个数字的小数点前半段长度小于第二个
            return -1;
        }

        //比较前半段
        for (int i = 0; i < num1Head.length(); i++) {
            if (num1Head.charAt(i) < num2Head.charAt(i)) {
                return -1;
            }

            if (num1Head.charAt(i) > num2Head.charAt(i)) {
                return 1;
            }
        }
        //比较后半段
        for (int i = 0; i < (num1Tail.length() > num2Tail.length() ? num1Tail.length() : num2Tail.length()); i++) {
            if (num1Tail.charAt(i) < num2Tail.charAt(i)) {
                return -1;
            }
            if (num1Tail.charAt(i) > num2Tail.charAt(i)) {
                return 1;
            }
        }

        if (num1Tail.length() > num2Tail.length()) {
            return 1;
        } else if (num1Tail.length() < num2Tail.length()) {
            return -1;
        } else {
            return 0;
        }

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
        //判断是否走减法流程
        boolean f1 = isNegativeNum(num1);
        boolean f2 = isNegativeNum(num2);
        String pre = "";
        if (f1 ^ f2) {
            return "";//TODO 减法
        } else {
            pre = num1.contains("-") ? "-" : "";
            num1 = num1.contains("-") || num1.contains("+") ? num1.substring(1) : num1;
            num2 = num2.contains("-") || num2.contains("+") ? num2.substring(1) : num2;
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
        return pre + result;
    }

    /**
     * 获取没有后面无用的0的数字
     *
     * @param num 数字
     * @return 结果
     */
    private static String getNumNoTailZeroAndHeadZero(String num) {
        String result = "0";

        //没有小数点
        boolean containsPoint = num.contains(".");
        String head = containsPoint ? num.substring(0, num.indexOf(".")) : num;
        String sourceHead = head;
        for (int i = 0; i < sourceHead.length(); i++) {
            if ("0".equals("" + head.charAt(i)) && i != (sourceHead.length() - 2)) {
                head = sourceHead.substring(i);
            } else {
                break;
            }
        }

        if (!containsPoint) {
            return result = head;
        }

        String tail = num.substring(num.indexOf(".") + 1);
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

}
