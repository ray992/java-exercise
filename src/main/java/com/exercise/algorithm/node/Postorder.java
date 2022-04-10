package com.exercise.algorithm.node;

import java.util.ArrayList;
import java.util.List;

public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        find(root, res);
        return res;
    }

    public void find(Node node, List<Integer> res){
        if (node == null){
            return;
        }
        for (Node childNode:node.children){
            find(childNode, res);
        }
        res.add(node.val);
    }
}
