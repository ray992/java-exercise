package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.PriorityQueue;

/**
 * @ClassName KthSmallest
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/17 上午12:23
 * @Version 1.0
 **/
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> treeValQueue= new PriorityQueue<>();
        traverse(root, treeValQueue);
        int res = 0;
        int i = 1;
        while (i <= k && !treeValQueue.isEmpty()){
            res = treeValQueue.poll();
            i++;
        }
        return res;
    }

    public void traverse(TreeNode treeNode, PriorityQueue<Integer> treeValQueue){
        if (treeNode == null){
            return;
        }
        treeValQueue.add(treeNode.getVal());
        traverse(treeNode.left, treeValQueue);
        traverse(treeNode.right, treeValQueue);
    }


}
