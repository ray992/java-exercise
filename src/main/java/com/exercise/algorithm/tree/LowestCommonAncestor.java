package com.exercise.algorithm.tree;

/**
 * @ClassName LowestCommonAncestor
 * @Description 二叉搜索树的最近公共祖先
 * @Author yeqiang
 * @Date 2022/7/7 9:52 AM
 * @Version 1.0
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }


}
