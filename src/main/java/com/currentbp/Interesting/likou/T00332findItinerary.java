package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import javafx.util.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/4/18 23:04
 */
public class T00332findItinerary {
    /*
    给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。

输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
输出：["JFK","MUC","LHR","SFO","SJC"]

输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。

解题思路：
1、以一个点作为开始，然后遍历行程，看看能否走的通
1.1、做一个from_to的map结构
1.2、标记是否行走过

todo not work
     */

    @Test
    public void t1() {
        StringUtil.printObject(findItinerary(Lists.newArrayList()));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return new ArrayList<>();
        }
        if (tickets.size() == 1) {
            return tickets.get(0);
        }

        for (int i=0;i<tickets.size();i++) {
            List<String> ticket = tickets.get(i);
            int[] ints = new int[tickets.size()];
            ints[i] = 1;
            boolean flag = doTicket(ticket, tickets, ints);
            if(flag){
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }

    private boolean doTicket(List<String> ticket, List<List<String>> tickets, int[] ints) {
        String from = ticket.get(0);
        String to = ticket.get(1);


        return false;
    }


}
