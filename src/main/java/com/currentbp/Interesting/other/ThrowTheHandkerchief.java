package com.currentbp.Interesting.other;

import com.currentbp.common.entity.ListNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 丢手绢
 *
 * @author baopan
 * @createTime 2020/8/10 19:36
 */
public class ThrowTheHandkerchief {


    @Test
    public void t1() {
        ListNode root = init(new int[]{1, 2, 3, 4, 5, 6, 7});
        StringUtil.printObject(root);
        int i = throwHandKerchief(root, 2);
        StringUtil.printObject(i);
    }

    private int throwHandKerchief(ListNode root, int n) {
        ListNode currentNode = root;
        ListNode beforeNode = null;
        while (size > 1) {
            int remove = 0;
            for (int i = 0; i < n; i++) {
                if (i != n - 1) {
                    beforeNode = currentNode;
                }
                remove = currentNode.val;
                currentNode = currentNode.next;
            }
            System.out.println("remove:" + remove);
            beforeNode.next = currentNode;
            size--;
        }
        return currentNode.val;
    }

    @Test
    public void tInit() {
        StringUtil.printObject(init(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    private int size = 0;

    private ListNode init(int[] m) {
        if (null == m || 0 == m.length) {
            return null;
        }
        size = m.length;
        ListNode root = new ListNode(m[0]);
        ListNode currentNode = root, temp = null;
        for (int i = 1; i < m.length; i++) {
            temp = new ListNode(m[i]);
            currentNode.next = temp;
            currentNode = temp;
        }
        currentNode.next = root;
        return root;
    }
}
