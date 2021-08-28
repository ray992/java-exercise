package com.exercise.algorithm.tree;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName FindSecondMinimumValue
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/27 下午9:09
 * @Version 1.0
 **/
public class FindSecondMinimumValue {

    private Set<Integer> nodeValueSet = new LinkedHashSet<>();

    public void traverse(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        nodeValueSet.add(treeNode.getVal());
        traverse(treeNode.getLeft());
        traverse(treeNode.getRight());
    }

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        if (nodeValueSet.size() == 1){
            return -1;
        }
        int i = 0;
        int second = 0;
        for (Integer val:nodeValueSet){
            i++;
            if (i == 1){
                continue;
            }
            if (i == 2){
                second = val;
                continue;
            }
            if (val < second){
                second = val;
            }

        }
        return second;
    }

    int ans = -1;

    public void traverse(TreeNode node, int cur){
        if (node == null){
            return;
        }
        if (node.val != cur){
            if (ans == -1){
                ans = node.val;
            }else {
                ans = Math.min(ans, node.val);
                return;
            }
        }
        traverse(node.getLeft(), cur);
        traverse(node.getRight(), cur);
    }

    public int findSecondMinimumValue2(TreeNode root){
        traverse(root, root.val);
        return ans;
    }

    public static void main(String[] args) {

    }
}
