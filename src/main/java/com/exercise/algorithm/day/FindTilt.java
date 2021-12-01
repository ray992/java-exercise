package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

/**
 * @ClassName FindTilt
 * @Description 二叉树坡度
 * @Author yeqiang
 * @Date 2021/11/18 上午10:09
 * @Version 1.0
 **/
public class FindTilt {

    int ans = 0;

    public int findTilt(TreeNode root){
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int sumLeftTree = dfs(treeNode.left);
        int sumRightTree = dfs(treeNode.right);
        ans+=Math.abs(sumLeftTree-sumRightTree);
        return sumLeftTree+sumRightTree+treeNode.val;
    }

    public static void main(String[] args) {
        System.out.println(7/2);
    }
}
