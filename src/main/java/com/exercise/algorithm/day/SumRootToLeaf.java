package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumRootToLeaf {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        bfs(root);
        return sum;
    }

   public void bfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        Deque<TreeData> deque = new ArrayDeque<>();
        deque.offer(new TreeData(treeNode,treeNode.val + ""));
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeData treeData = deque.poll();
                if (treeData == null){
                    continue;
                }
                TreeNode curTreeNode = treeData.treeNode;
                if (curTreeNode.left == null && curTreeNode.right == null){
                    sum += Integer.parseInt(treeData.valString, 2);
                    continue;
                }
                if (treeNode.left != null){
                    deque.offer(new TreeData(curTreeNode.left, treeData.valString+curTreeNode.val));
                }
                if (treeNode.right != null){
                    deque.offer(new TreeData(curTreeNode.right, treeData.valString+curTreeNode.val));
                }
            }
        }
   }

    public static void main(String[] args) {
        System.out.println(0 << 1 | 1);
    }

}

class TreeData {

    TreeNode treeNode;
    String valString;

    public TreeData(TreeNode treeNode, String valString) {
        this.treeNode = treeNode;
        this.valString = valString;
    }
}

