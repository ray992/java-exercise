package com.exercise.algorithm.day;


import java.util.Deque;
import java.util.LinkedList;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeData> deque = new LinkedList<>();
        deque.offer(new TreeData(root, 1));
        int maxDepth = 1;
        while (!deque.isEmpty()){
            TreeData treeData = deque.poll();
            TreeNode treeNode = treeData.treeNode;
            maxDepth = Math.max(maxDepth, treeData.depth);
            if (treeNode.left != null){
                deque.offer(new TreeData(treeNode.left, treeData.depth + 1));
            }
            if (treeNode.right != null){
                deque.offer(new TreeData(treeNode.right, treeData.depth + 1));
            }
        }
        int sum = 0;
        deque.offer(new TreeData(root, 1));
        while (!deque.isEmpty()){
            TreeData treeData = deque.poll();
            TreeNode treeNode = treeData.treeNode;
            if (treeData.depth == maxDepth){
                sum += treeNode.val;
            }
            if (treeNode.left != null){
                deque.offer(new TreeData(treeNode.left, treeData.depth + 1));
            }
            if (treeNode.right != null){
                deque.offer(new TreeData(treeNode.right, treeData.depth + 1));
            }
        }
        return sum;
    }

    static class TreeData {
        private TreeNode treeNode;
        private int depth;

        public TreeData(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public void setTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }
}
