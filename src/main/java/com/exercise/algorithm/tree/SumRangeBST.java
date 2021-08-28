package com.exercise.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SumRangeBST
 * @Description 二叉搜索树的范围和
 * @Author yeqiang
 * @Date 2021/5/25 4:50 下午
 * @Version 1.0
 **/
public class SumRangeBST {

    public static int solution(TreeNode root, int low, int high){
        int sum = 0;
        if (root == null){
            return sum;
        }
        List<Integer> treeNodeList = new ArrayList<>();
        traverse(root, treeNodeList);
        if (treeNodeList.size() > 0){
            for (Integer nodeVal:treeNodeList){
                if (nodeVal >= low && nodeVal <= high){
                    sum +=nodeVal;
                }
            }
        }
        return sum;
    }

    public static void traverse(TreeNode treeNode, List<Integer> treeNodeList){
        if (treeNode == null){
            return;
        }
        treeNodeList.add(treeNode.getVal());
        traverse(treeNode.getLeft(), treeNodeList);
        traverse(treeNode.getRight(), treeNodeList);
    }


    public static void main(String[] args) {
        TreeNode rootLeft = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        TreeNode rootRight = new TreeNode(15, null, new TreeNode(18));
        TreeNode root = new TreeNode(10, rootLeft, rootRight);
        System.out.println(solution(root, 3, 18));
    }
}
