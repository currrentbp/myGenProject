package com.currentbp.Interesting.other.afterXIAOMI;

import com.currentbp.common.entity.LinkNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/12 21:02
 */
public class LinkNodeRemoveNode {
    /*
    删除链表的倒数第N个节点
     */
    @Test
    public void t1() {
        String s1 = "";
        System.out.println(removeN(new LinkNode(Lists.newArrayList(1,2,3,4)),-1));
    }

    private LinkNode removeN(LinkNode sources, int n) {
        if (sources == null) {
            return sources;
        }
        if (n <= 0) {
            return sources;
        }

        int length = getLinkNodeLength(sources);
        if (length < n) {
            return sources;
        }

        LinkNode newHead = new LinkNode(0);
        newHead.next = sources;

        //删除第length-n个元素，从0开始的
        /*如：一共2个元素，删除倒数第二个，也就是顺数第一个
        一共2个元素，删除倒数第一个，也就是顺数第二个
         */
        int needDeleteIndex = length - n + 1;

        LinkNode before = newHead, middle = before.next;
        int i = 1;
        while (middle != null) {
            if (needDeleteIndex == i) {
                before.next = middle.next;
                break;
            }
            before = middle;
            middle = middle.next;
            i++;
        }

        return newHead.next;
    }

    private int getLinkNodeLength(LinkNode sources) {
        if (sources == null) {
            return 0;
        }
        int result = 0;
        while (sources != null) {
            result++;
            sources = sources.next;
        }
        return result;
    }
}
