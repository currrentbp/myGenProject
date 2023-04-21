package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T0117connect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> tops = new ArrayList<>();
        List<Node> temps = new ArrayList<>();

        tops.add(root);
        while (true) {
            for (int i = 0; i < tops.size(); i++) {
                if (i + 1 == tops.size()) {
                    tops.get(i).next = null;
                } else {
                    tops.get(i).next = tops.get(i + 1);
                }
            }

            for (int i = 0; i < tops.size(); i++) {
                if (tops.get(i).left != null) {
                    temps.add(tops.get(i).left);
                }
                if (tops.get(i).right != null) {
                    temps.add(tops.get(i).right);
                }
            }

            tops = temps;
            temps = new ArrayList<>();
            if (tops.size() == 0) {
                break;
            }
        }
        return root;
    }
}
