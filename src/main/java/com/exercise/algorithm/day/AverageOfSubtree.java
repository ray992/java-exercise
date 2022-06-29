package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AverageOfSubtree
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/8 10:36 AM
 * @Version 1.0
 **/
public class AverageOfSubtree {

    int ans = 0, sum = 0, num = 0;

    int cnt;

    public int averageOfSubtree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = 0;
        List<TreeNode> treeNodeList = new ArrayList<>();
        getSumNode(root, treeNodeList);
        for (TreeNode treeNode:treeNodeList){
            int[] data = {0, 0};
            bianli(treeNode, data);
            if (treeNode.val == data[0] / data[1]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

    public void getSumNode(TreeNode treeNode, List<TreeNode> treeNodeList){
        if (treeNode == null){
            return;
        }
        treeNodeList.add(treeNode);
        getSumNode(treeNode.left, treeNodeList);
        getSumNode(treeNode.right, treeNodeList);
    }

    public void bianli(TreeNode treeNode, int[] data){
        if (treeNode == null){
            return;
        }
        data[0] += treeNode.val;
        data[1] += 1;
        bianli(treeNode.left, data);
        bianli(treeNode.right, data);
    }

    public int averageOfSubtree2(TreeNode root){
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        num = 0;
        sum = 0;
        visit(treeNode);
        if (sum / num == treeNode.val){
            ans++;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);
    }

    public void visit(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        num ++;
        sum += treeNode.val;
        visit(treeNode.left);
        visit(treeNode.right);
    }


    public int averageOfSubtree3(TreeNode root){
        dfs2(root);
        return cnt;
    }

    public int[] dfs2(TreeNode treeNode){
        if (treeNode == null){
            return new int[]{0, 0, 0};
        }
        int[] l = dfs2(treeNode.left);
        int[] r = dfs2(treeNode.right);
        int sum = l[0] + r[0] + treeNode.val;
        int num = l[1] + r[1] + 1;
        int avg = sum / num;
        if (avg == treeNode.val){
            cnt++;
        }
        return new int[]{sum, num, avg};
    }
}
