package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftValue {

    int maxDepth = Integer.MIN_VALUE;
    int res = 0;

    //bfs
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            root = deque.poll();
            if (root.right != null){
                deque.offer(root.right);
            }
            if (root.left != null){
                deque.offer(root.left);
            }
        }
        return root.val;
    }

    //dfs
    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode treeNode, int depth){
        if (treeNode != null){
            if (treeNode.left == null && treeNode.right == null){
                if (maxDepth < depth){
                    maxDepth = depth;
                    res = treeNode.val;
                }
            }
            dfs(treeNode.left, depth+1);
            dfs(treeNode.right, depth + 1);
        }
    }

}
