package com.exercise.algorithm.tree;

import java.util.*;

public class FindTarget {

    TreeSet<Integer> nodeTreeSet = null;

    public boolean findTarget(TreeNode root, int k) {
        nodeTreeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        preOrder(root);
        for (Integer element : nodeTreeSet) {
            Integer anotherEle = k - element;
            if (!element.equals(anotherEle) && nodeTreeSet.contains((anotherEle))) {
                return true;
            }
        }
        return false;
    }

    public void preOrder(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        nodeTreeSet.add(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        TreeNode treeNode = new TreeNode(1);
        System.out.println(findTarget.findTarget(treeNode, 2));
    }
}
