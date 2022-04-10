package com.exercise.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Deque<TreeNodeData> deque = new ArrayDeque<>();
        deque.offer(new TreeNodeData(root, null, 0));
        while (!deque.isEmpty()){
            int curSize = deque.size();
            for (int i = 0; i < curSize; i++){
                TreeNodeData treeNodeData = deque.poll();
                TreeNode curParentTreeNode = treeNodeData.parentTreeNode;
                TreeNode curTreeNode = treeNodeData.treeNode;
                int curPosition = treeNodeData.childPosition;
                if (curParentTreeNode != null && curPosition > 0){
                    if (curPosition == 1){
                        curParentTreeNode.right = curTreeNode;
                    }else if (curPosition == 2){
                        curParentTreeNode.left = curTreeNode;
                    }
                }
                if (curTreeNode != null){
                    deque.offer(new TreeNodeData(curTreeNode.left, curTreeNode, 1));
                    deque.offer(new TreeNodeData(curTreeNode.right, curTreeNode, 2));
                }
            }
        }
        return root;
    }

    public TreeNode invertTreeByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    class TreeNodeData {
        TreeNode treeNode;
        TreeNode parentTreeNode;
        int childPosition;

        public TreeNodeData(TreeNode treeNode, TreeNode parentTreeNode, int childPosition) {
            this.treeNode = treeNode;
            this.parentTreeNode = parentTreeNode;
            this.childPosition = childPosition;
        }
    }
}
