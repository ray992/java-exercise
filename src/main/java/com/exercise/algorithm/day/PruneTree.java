package com.exercise.algorithm.day;

/**
 * @ClassName PruneTree
 * @Description 二叉树剪枝
 * @Author yeqiang
 * @Date 2022/7/21 9:36 AM
 * @Version 1.0
 **/
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}
