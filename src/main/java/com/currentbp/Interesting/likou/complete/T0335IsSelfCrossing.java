package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/8 19:33
 */
public class T0335IsSelfCrossing {
    /*
给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，
向南移动 x[2] 米，向东移动 x[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
示例 1:
┌───┐
│     │
└───┼──>
      │
输入: [2,1,1,2]
输出: true
示例 2:
┌──────┐
│         │
│
│
└────────────>
输入: [1,2,3,4]
输出: false
示例 3:
┌───┐
│     │
└───┼>
输入: [1,1,1,1]
输出: true

解题思路：
1、由于是沿着逆时针走，而且是正数的，所以必定是一个回型图形
2、直线A、B、C、D、E、F，下一条直线为H
3、新的直线H只能碰到D、C、B（A：碰到A也就意味着碰到了B），
   也就是说新生成的线需要向上找2条线后再找3条线判断是否有交点（即第三条线开始）
     */
    @Test
    public void tGetLine() {
        StringUtil.printObject(getLine(new int[]{1, 1}, 3, 0));
        StringUtil.printObject(getLine(new int[]{1, 1}, 3, 1));
        StringUtil.printObject(getLine(new int[]{1, 1}, 3, 2));
        StringUtil.printObject(getLine(new int[]{1, 1}, 3, 3));
    }


    @Test
    public void t1() {
        StringUtil.printObject(isSelfCrossing(new int[]{2, 1, 1, 2}));//true
        StringUtil.printObject(isSelfCrossing(new int[]{1, 2, 3, 4}));//false
        StringUtil.printObject(isSelfCrossing(new int[]{1, 1, 1, 1}));//true
        StringUtil.printObject(isSelfCrossing(new int[]{1,1,2,1,1}));//true
        StringUtil.printObject(isSelfCrossing(new int[]{3, 3, 3, 2, 1, 1}));//false
    }

    public boolean isSelfCrossing(int[] x) {
        if (null == x || x.length <= 3) {
            return false;
        }
        //定义：线的结构int[4]{startx,starty,endx,endy}
        List<int[]> allLines = initLines(x);
        boolean result = checkHasCrossing(allLines);
        return result;
    }

    private List<int[]> initLines(int[] x) {
        List<int[]> allLines = new ArrayList<>(x.length);
        int[] currentPoint = new int[]{0, 0};
        for (int i = 0; i < x.length; i++) {
            int[] line = getLine(currentPoint, x[i], i % 4);
            allLines.add(line);
            currentPoint = new int[]{line[2], line[3]};
        }
        return allLines;
    }

    /**
     * 检查是否出现交叉的线
     */
    private boolean checkHasCrossing(List<int[]> allLines) {
        for (int i = 0; i < allLines.size(); i++) {
            int[] currentLine = allLines.get(i);
            if (i - 3 >= 0) {
                int[] firstLine = allLines.get(i - 3);
                if (doCheckEachHasCrossing(currentLine, firstLine)) {
                    return true;
                }
            }
            if (i - 4 >= 0) {
                int[] firstLine = allLines.get(i - 4);
                if (doCheckEachHasCrossing(currentLine, firstLine)) {
                    return true;
                }
            }
            if (i - 5 >= 0) {
                int[] firstLine = allLines.get(i - 5);
                if (doCheckEachHasCrossing(currentLine, firstLine)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断两条线是否相交
     *
     * @param newLine    新生成的线
     * @param beforeLine 以前的线（两条前的线）
     * @return 是否相交
     */
    private boolean doCheckEachHasCrossing(int[] newLine, int[] beforeLine) {
        //1、两条线平行，判断两条线是否重合了
        //2、两条线不是平行的，判断是否是相交的
        boolean isYLine = newLine[0] == newLine[2] && beforeLine[0] == beforeLine[2]; //两条线段都是Y轴平行
        boolean isXLine = newLine[1] == newLine[3] && beforeLine[1] == beforeLine[3]; //两条线段都是X轴平行
        if (isXLine) {//X轴平行的
            if (newLine[1] == beforeLine[1]) {//同一个Y轴上
                if (between(newLine[0], newLine[2], beforeLine[0])
                        || between(newLine[0], newLine[2], beforeLine[2])
                        || between(beforeLine[0], beforeLine[2], newLine[0])
                        || between(beforeLine[0], beforeLine[2], newLine[2])) {//判断两个线段是否有重合的部分
                    return true;
                } else {
                    return false;
                }
            } else {//平行，两个线段仅仅平行
                return false;
            }
        }
        if (isYLine) {//Y轴平行的
            if (newLine[0] == beforeLine[0]) {//两个线段在同一个直线上
                if (between(newLine[1], newLine[3], beforeLine[1])
                        || between(newLine[1], newLine[3], beforeLine[3])
                        || between(beforeLine[1], beforeLine[3], newLine[1])
                        || between(beforeLine[1], beforeLine[3], newLine[3])) {//判断两个线段是否有重合的部分
                    return true;
                } else {
                    return false;
                }
            } else {//平行，两个线段仅仅平行
                return false;
            }
        }

        if(newLine[0] == newLine[2]) {//第一个线段是Y轴平行的
            //最有可能的点
            int[] possiblePoint = {newLine[0], beforeLine[1]};
            boolean isOn = betweenPoint(beforeLine, possiblePoint)
                    && betweenPoint(newLine, possiblePoint);
            return isOn;
        }
        if(beforeLine[0] == beforeLine[2]){//第二个线段是Y轴平行的
            //最有可能的点
            int[] possiblePoint = {beforeLine[0], newLine[1]};
            boolean isOn = betweenPoint(beforeLine, possiblePoint)
                    && betweenPoint(newLine, possiblePoint);
            return isOn;
        }
        return false;
    }

    /**
     * 判断点是否在线上
     *
     * @param line  线段
     * @param point 点
     */
    private boolean betweenPoint(int[] line, int[] point) {
        if (line[0] == line[2] && line[0] == point[0] && between(line[1], line[3], point[1])) {//Y轴平行的线，该点在线段上
            return true;
        }
        if (line[1] == line[3] && line[1] == point[1] && between(line[0], line[2], point[0])) {//X轴平行的线，该点在线段上
            return true;
        }
        return false;
    }

    private boolean between(int n1, int n2, int target) {
        if (n1 >= n2) {//得到结果是n1 < n2
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        if (n1 <= target && target <= n2) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取一条线段
     *
     * @param currentPoint 当前点
     * @param x            前进的偏移量
     * @param flag         方向：0：上，1，左，2：下，3，右
     * @return 一个线段
     */
    private int[] getLine(int[] currentPoint, int x, int flag) {
        int[] line = new int[4];
        line[0] = currentPoint[0];
        line[1] = currentPoint[1];

        //方向：0：上，1，左，2：下，3，右
        if (flag == 0) {
            line[2] = currentPoint[0];
            line[3] = currentPoint[1] + x;
        }
        if (flag == 1) {
            line[2] = currentPoint[0] - x;
            line[3] = currentPoint[1];
        }
        if (flag == 2) {
            line[2] = currentPoint[0];
            line[3] = currentPoint[1] - x;
        }
        if (flag == 3) {
            line[2] = currentPoint[0] + x;
            line[3] = currentPoint[1];
        }
        return line;
    }


    /**
     * 官方最佳
     */
    public boolean isSelfCrossing2(int[] x) {
        if(x.length <= 3)
            return false;
        int i, xl = x[1], yl = x[0], px = 0, py = 0;
        //检测a类型路径的变化趋势
        for(i = 2; i < x.length; i++){
            if((i & 0x1) == 1){
                if(x[i] <= xl){
                    //a ---> b
                    if(xl - px <= x[i])
                        yl -= py;
                    xl = x[i];
                    break;
                }
                //用px保存xl的旧值
                px = xl;
                xl = x[i];
            }else {
                if(x[i] <= yl){
                    //a ---> b
                    if(yl - py <= x[i])
                        xl -= px;
                    yl = x[i];
                    break;
                }
                //用py保存yl的旧值
                py = yl;
                yl = x[i];
            }
        }
        //检测b类型路径的变化趋势
        for(i++; i < x.length; i++){
            if((i & 0x1) == 1 && x[i] < xl){
                xl = x[i];
            }else if(x[i] < yl){
                yl = x[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
