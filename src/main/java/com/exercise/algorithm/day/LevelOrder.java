package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LevelOrder
 * @Description 层序遍历
 * @Author yeqiang
 * @Date 2022/6/22 11:30 PM
 * @Version 1.0
 **/
public class LevelOrder {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null){
            Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
            treeNodeDeque.offer(root);
            while (!treeNodeDeque.isEmpty()){
                int size = treeNodeDeque.size();
                List<Integer> layerList = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode curTreeNode = treeNodeDeque.poll();
                    if (curTreeNode == null){
                        continue;
                    }
                    layerList.add(curTreeNode.val);
                    if (curTreeNode.left != null){
                        treeNodeDeque.offer(curTreeNode.left);
                    }
                    if (curTreeNode.right != null){
                        treeNodeDeque.offer(curTreeNode.right);
                    }
                }
                if (layerList.size() > 0){
                    resultList.add(layerList);
                }
            }
        }
        return resultList;
    }

}
