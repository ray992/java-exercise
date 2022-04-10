package com.exercise.algorithm.node;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树前序遍历
 */
public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        find(root, res);
        return res;
    }

    public void find(Node node, List<Integer> res){
        if (node == null){
            return;
        }
        res.add(node.val);
        for (Node childNode:node.children){
            find(childNode, res);
        }
    }
}
