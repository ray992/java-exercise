package com.exercise.algorithm.tree;

/**
 * 根据二叉树创建字符串
 */
public class Tree2str {

    StringBuilder res = new StringBuilder();

    public String tree2str(TreeNode root) {
        preOrder(root);
        String resString = res.toString();
        return resString.substring(1, resString.lastIndexOf(")"));
    }

    public void preOrder(TreeNode curNode){
        res.append("(");
        if (curNode != null){
            res.append(curNode.val);
        }
        if (curNode != null &&  (curNode.left != null || curNode.right != null)){
            preOrder(curNode.left);
        }
        if (curNode != null &&  curNode.right != null){
            preOrder(curNode.right);
        }
        res.append(")");
    }

}
