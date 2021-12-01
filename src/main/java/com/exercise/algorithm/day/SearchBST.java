package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

/**
 * @ClassName SearchBST
 * @Description 二叉搜索树中搜索
 * @Author yeqiang
 * @Date 2021/11/26 上午9:52
 * @Version 1.0
 **/
public class SearchBST {

    TreeNode targetChildTreeNode = null;

    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root, val);
        return targetChildTreeNode;
    }

    public void traverse(TreeNode treeNode, int val){
        if (treeNode == null){
            return;
        }
        if (treeNode.val == val){
            targetChildTreeNode = treeNode;
            return;
        }
        traverse(treeNode.left, val);
        traverse(treeNode.right, val);
    }
}
