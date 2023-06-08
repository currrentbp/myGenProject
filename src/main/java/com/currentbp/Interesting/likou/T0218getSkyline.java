package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 6/4/2023 9:19 AM
 */
public class T0218getSkyline {
    /*
城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
lefti 是第 i 座建筑物左边缘的 x 坐标。
righti 是第 i 座建筑物右边缘的 x 坐标。
heighti 是第 i 座建筑物的高度。
你可以假设所有的建筑都是完美的长方形，在高度为 0的绝对平坦的表面上。
天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
示例 1：
输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
解释：
图 A 显示输入的所有建筑物的位置和高度，
图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
示例 2：

输入：buildings = [[0,2,3],[2,5,3]]
输出：[[0,3],[5,0]]

解题思路：
1、获取所有点，去掉所有被包含的点
2、组装天际线的点：i个点和i+1个点肯定不在同一水平线上，其中i+1点必须在i点的上面或者下面，且中间间隔一个点

todo 解题思路错误，错误在排序上


     */

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();


        List<List<Integer>> noIncludePoints = removeIncludePoints(buildings);

        List<List<Integer>> sortPoints = sortPoints(noIncludePoints);

        doGetSkyline(result, sortPoints);

        return result;
    }

    private void doGetSkyline(List<List<Integer>> result, List<List<Integer>> sortPoints) {

    }

    @Test
    public void t1(){
        StringUtil.printObject(sortPoints(Lists.newArrayList(Lists.newArrayList(1,0),Lists.newArrayList(0,0),
                Lists.newArrayList(0,2),Lists.newArrayList(1,2))));
    }
    //todo 此处错误
    private List<List<Integer>> sortPoints(List<List<Integer>> allPoints) {
        List<List<Integer>> result = allPoints.stream().sorted((x, y) -> {
            if (x.get(0) < y.get(0)) {
                return -1;
            } else if (x.get(0) > y.get(0)) {
                return 1;
            } else {
                return x.get(1) - y.get(1);
            }
        }).collect(Collectors.toList());
        return result;
    }

    private List<List<Integer>> removeIncludePoints(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] currentBuilder = buildings[i];
            boolean leftDown = true, leftTop = true, rightDown = true, rightTop = true;
            for (int j = 0; j < buildings.length; j++) {
                //排除相同的建筑
                if (i == j) {
                    continue;
                }
                int[] itemBuilder = buildings[j];
                //分别判断当前建筑的每个点是否成为阴影了，true：表示可以展示的点，false：成为阴影了
                if (leftDown) {
                    leftDown = notInBuilding(new int[]{currentBuilder[0], 0}, itemBuilder);
                }
                if (leftTop) {
                    leftTop = notInBuilding(new int[]{currentBuilder[0], currentBuilder[2]}, itemBuilder);
                }
                if (rightTop) {
                    rightTop = notInBuilding(new int[]{currentBuilder[1], currentBuilder[2]}, itemBuilder);
                }
                if (rightDown) {
                    rightDown = notInBuilding(new int[]{currentBuilder[1], 0}, itemBuilder);
                }
            }
            //如果一个点始终不在其他建筑的阴影内，则可以展示这个点
            if (leftDown) {
                result.add(Lists.newArrayList(currentBuilder[0], 0));
            }
            if (leftTop) {
                result.add(Lists.newArrayList(currentBuilder[0], currentBuilder[2]));
            }
            if (rightTop) {
                result.add(Lists.newArrayList(currentBuilder[1], currentBuilder[2]));
            }
            if (rightDown) {
                result.add(Lists.newArrayList(currentBuilder[1], 0));
            }

        }
        return result;
    }

    private boolean notInBuilding(int[] point, int[] builder) {
        if (point[0] < builder[0] || point[0] > builder[1]) {
            return true;
        }
        if (point[1] > builder[2]) {
            return true;
        }
        return false;
    }


}
