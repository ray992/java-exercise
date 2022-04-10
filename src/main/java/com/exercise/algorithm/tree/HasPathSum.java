package com.exercise.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 路径总和
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        boolean status = false;
        Deque<TreeNodeNum> deque = new ArrayDeque<>();
        deque.offer(new TreeNodeNum(root, 0));
        while (!deque.isEmpty()){
            int curSize = deque.size();
            for (int i = 0; i < curSize;  i++){
                TreeNodeNum treeNodeNum = deque.poll();
                TreeNode curTreeNode = treeNodeNum.treeNode;
                int sum = treeNodeNum.sum;
                if (curTreeNode.val + sum == targetSum && curTreeNode.left == null && curTreeNode.right == null){
                    status = true;
                    break;
                }
                if (curTreeNode.left != null){
                    deque.offer(new TreeNodeNum(curTreeNode.left, curTreeNode.val+ sum));
                }
                if (curTreeNode.right != null){
                    deque.offer(new TreeNodeNum(curTreeNode.right, curTreeNode.val+ sum));
                }
            }
            if (status){
                break;
            }
        }
        return status;
    }

    class TreeNodeNum {
        TreeNode treeNode;
        int sum;

        public TreeNodeNum(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }
}
