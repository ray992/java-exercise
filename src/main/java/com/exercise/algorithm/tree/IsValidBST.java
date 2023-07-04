package com.exercise.algorithm.tree;

/**
 * @ClassName IsValidBST
 * @Description 验证二叉搜索树
 * @Author yeqiang
 * @Date 2022/7/7 9:25 AM
 * @Version 1.0
 **/
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode treeNode, long left, long right){
        if (treeNode == null){
            return true;
        }
        if (treeNode.val <= left || treeNode.val >= right){
            return false;
        }
        return isValidBST(treeNode.left, left, treeNode.val) && isValidBST(treeNode.right, treeNode.val, right);
    }
}
