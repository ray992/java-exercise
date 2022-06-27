package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class IsUnivalTree {

    public static boolean singleValStatus = true;

    public boolean isUnivalTree(TreeNode root) {
        //Set<Integer> nodeValueSet = new HashSet<>();
        //postOrder(nodeValueSet, root, true);
       //return singleValStatus;
        return dfs(root, root.val);
    }

    public boolean isUnivalTree2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode curTreeNode = deque.poll();
            if (curTreeNode.val != root.val){
                return false;
            }
            if (curTreeNode.left != null){
                deque.offer(curTreeNode.left);
            }
            if (curTreeNode.right != null){
                deque.offer(curTreeNode.right);
            }
        }
        return true;
    }


    public void postOrder(Set<Integer> nodeValueSet, TreeNode treeNode, boolean firstInsert){
        if (treeNode == null){
            return;
        }
        if (firstInsert){
            nodeValueSet.add(treeNode.val);
        }else {
            if (nodeValueSet.add(treeNode.val)){
                singleValStatus = false;
            }
        }
        postOrder(nodeValueSet, treeNode.left, false);
        postOrder(nodeValueSet, treeNode.right, false);
    }

    public boolean dfs(TreeNode treeNode, int val){
        if (treeNode == null){
            return true;
        }
        if (treeNode.val != val){
            return false;
        }
        return dfs(treeNode.left, val) && dfs(treeNode.right, val);
    }

    public static void main(String[] args) {
        IsUnivalTree isUnivalTree = new IsUnivalTree();
        System.out.println(isUnivalTree.isUnivalTree(new TreeNode(0)));
    }

}
