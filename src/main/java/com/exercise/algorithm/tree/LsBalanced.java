package com.exercise.algorithm.tree;

/**
 * @ClassName LsBalanced
 * @Description 二叉树平衡
 * @Author yeqiang
 * @Date 2021/9/12 上午11:56
 * @Version 1.0
 **/
public class LsBalanced {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
