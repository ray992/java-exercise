package com.exercise.algorithm.competition.intsig;

import com.exercise.algorithm.tree.TreeNode;

/**
 * @ClassName EvaluateTree
 * @Description 计算布尔二叉树的值
 * @Author yeqiang
 * @Date 2022/7/9 10:33 PM
 * @Version 1.0
 **/
public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
       if (root.left == null && root.right == null){
           return root.val > 0;
       }
       return root.val == 3 ? evaluateTree(root.left) && evaluateTree(root.right): evaluateTree(root.left) || evaluateTree(root.right);
    }
}
