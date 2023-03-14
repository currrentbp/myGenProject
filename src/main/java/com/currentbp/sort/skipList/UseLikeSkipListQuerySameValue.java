package com.currentbp.sort.skipList;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/3/2 21:59
 */
public class UseLikeSkipListQuerySameValue {
    /*
问题描述：多组数组中，找出相同元素（所有数组中都存在这个元素）
解题思路：
1、将数组转换成hashSet，然后遍历第一个数组，判断出公共元素，最容易实现
2、使用类似调表思路查出公共元素，难度适中
3、将数组中的数字转成bitmap结构，然后将转换后的bitmap进行按位与的出的结果，难点：转换成bitmap结构，反转也是同样的
     */

    @Test
    public void checkSameValue() {
        List<List<Integer>> sources = new ArrayList<>();
        sources.add(Lists.newArrayList(1));
        sources.add(Lists.newArrayList(1, 2, 3, 7, 9, 10));
        sources.add(Lists.newArrayList(1, 3, 7, 9, 11));
        sources.add(Lists.newArrayList(1, 3, 4, 5, 7, 9, 12));
        List<Integer> result = doCheck(sources);
        StringUtil.printObject(result);
    }

    private List<Integer> doCheck(List<List<Integer>> sources) {
        List<Integer> result = new ArrayList<>();
        //简单检查：判空
        if (sources == null || sources.size() == 0) {
            return result;
        }
        for (List<Integer> source : sources) {
            if (source == null || source.size() == 0) {
                return result;
            }
        }

        //如果只有一个列表，则表示可以直接全部返回，因为这个列表的数据都是相同的
        if (sources.size() == 1) {
            return sources.get(0);
        }

        //根据数组长度从小到大排序
        List<List<Integer>> newSources = new ArrayList<>();
        for (List<Integer> source : sources) {
            //todo 此处不做了
        }

        List<Integer> firstLists = sources.get(0);
        int[] indexs = new int[sources.size()];
        for (int currentListIndex = 0; currentListIndex < firstLists.size(); currentListIndex++) {
            int currentValue = firstLists.get(currentListIndex);
            indexs[0] = currentListIndex;
            boolean isSame = true;
            //必然有第二个元素
            for (int nextListIndex = 1; nextListIndex < sources.size(); nextListIndex++) {
                boolean hs = hasSomeFromLists(currentValue, sources.get(nextListIndex), nextListIndex, indexs);
                if (!hs) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                result.add(firstLists.get(currentListIndex));
            }
        }

        return result;
    }

    private boolean hasSomeFromLists(int targetValue, List<Integer> sources,
                                     int listIndex, int[] listStartIndexes) {
        int listStartIndex = listStartIndexes[listIndex];
        if (listStartIndex >= sources.size()) {
            return false;
        }
        for (int i = listStartIndex; i < sources.size(); i++) {
            Integer currentValue = sources.get(i);
            if (targetValue == currentValue) {
                listStartIndexes[listIndex] = i;
                return true;
            }
            if (targetValue > currentValue) {
                listStartIndexes[listIndex] = i;
            } else {
                break;
            }
        }

        return false;
    }
}
