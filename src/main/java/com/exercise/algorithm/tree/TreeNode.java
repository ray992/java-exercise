package com.exercise.algorithm.tree;

/**
 * @ClassName TreeNode
 * @Description 树节点
 * @Author yeqiang
 * @Date 2021/5/25 4:48 下午
 * @Version 1.0
 **/
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
