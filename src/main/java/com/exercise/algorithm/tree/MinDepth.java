package com.exercise.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return depth;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int curSize = deque.size();
            boolean isExistLeaf = false;
            for (int i = 0; i < curSize; i++){
                TreeNode curTreeNode = deque.pollFirst();
                if (curTreeNode != null ){
                    if (curTreeNode.left == null && curTreeNode.right == null){
                        isExistLeaf = true;
                    }else {
                        if (curTreeNode.left != null){
                            deque.addLast(curTreeNode.left);
                        }
                        if (curTreeNode.right != null){
                            deque.addLast(curTreeNode.right);
                        }
                    }
                }
            }
            depth++;
            if (isExistLeaf){
                break;
            }
        }
        return depth;
    }
}
