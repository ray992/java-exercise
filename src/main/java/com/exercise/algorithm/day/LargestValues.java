package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LargestValues
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/26 10:58 AM
 * @Version 1.0
 **/
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int tempMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode treeNode = deque.poll();
                assert treeNode != null;
                tempMax = Math.max(tempMax, treeNode.val);
                if (treeNode.left != null){
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.offer(treeNode.right);
                }
            }
            resultList.add(tempMax);
        }
        return resultList;
    }
}
