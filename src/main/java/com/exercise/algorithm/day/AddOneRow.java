package com.exercise.algorithm.day;

public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root.left == null &&  root.right == null && depth == 1){
            return new TreeNode(val, root, null);
        }
        postOrder(root, 1, depth, val);
        return root;
    }

    public void postOrder(TreeNode treeNode, int curDepth, int targetDepth, int val){
        if (treeNode == null){
            return;
        }
        if (curDepth == targetDepth - 1){
            treeNode.left = new TreeNode(val, treeNode.left.left, null);
            treeNode.right = new TreeNode(val, null, treeNode.right.right);
            return;
        }
        postOrder(treeNode.left, curDepth + 1, targetDepth, val);
        postOrder(treeNode.right, curDepth + 1, targetDepth, val);
    }
}
