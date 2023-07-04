package com.exercise.algorithm.node;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Preorder1
 * @Description N叉树的前序遍历
 * @Author yeqiang
 * @Date 2022/7/6 9:57 AM
 * @Version 1.0
 **/
public class Preorder1 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        prePostOrder(root, result);
        return result;
    }

    public void prePostOrder(Node root, List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        for (Node childNode: root.children){
            prePostOrder(childNode, result);
        }
    }

}
