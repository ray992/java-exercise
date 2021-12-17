package com.exercise.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName IsSymmetric
 * @Description 对称二叉树
 * @Author yeqiang
 * @Date 2021/12/13 下午11:14
 * @Version 1.0
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.offer(root.left);
        tmpQueue.offer(root.right);
        while (!tmpQueue.isEmpty()){
            TreeNode curLeft = tmpQueue.poll();
            TreeNode curRight = tmpQueue.poll();
            if (curLeft == null && curRight == null){
                continue;
            }
            if (curLeft == null || curRight == null){
                return false;
            }
            if (curLeft.val != curRight.val){
                return false;
            }
            tmpQueue.offer(curLeft.left);
            tmpQueue.offer(curRight.right);
            tmpQueue.offer(curLeft.right);
            tmpQueue.offer(curRight.left);
        }
        return true;
    }
}
