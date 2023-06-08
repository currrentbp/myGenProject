package com.currentbp.Interesting.likou.cannot;

import com.currentbp.common.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/21 22:27
 */
public class T1206Skiplist {
    /*
不使用任何库函数，设计一个 跳表 。
跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。

     */

    class Skiplist {
        private int maxLevel = 5;
        private Node head;
//        private List<Node> levelHeads = new ArrayList<>(maxLevel);

        public Skiplist() {

        }

        public boolean search(int target) {
            if (head == null) {
                return false;
            }
            return doSearch(head, target);
        }

        private boolean doSearch(Node head, int target) {
            if (head == null) {
                return false;
            }
            if (head.val == target) {
                return true;
            }
            if (head.next == null) {
                return doSearch(head.down, target);
            } else if (head.next.val < target) {
                return doSearch(head.down, target);
            } else if (head.next.val >= target) {
                return doSearch(head.next, target);
            }
            return false;
        }

        public void add(int num) {

        }

        public boolean erase(int num) {
            return false;
        }
    }
}
