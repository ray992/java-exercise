package com.exercise.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IsSameTree
 * @Description 相同的树
 * @Author yeqiang
 * @Date 2021/12/13 下午10:25
 * @Version 1.0
 **/
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        bfs(p, list1);
        bfs(q, list2);
        if (list1.size() != list2.size()){
            return false;
        }
        for (int i = 0; i < list1.size(); i++){
            Integer l1 = list1.get(i);
            Integer l2 = list2.get(i);
            if ((l1 == null && l2 != null) || (l2 == null && l1 != null)){
                return false;
            }
            if (l1 != null && !l1.equals(l2)){
                return false;
            }
        }
        return true;
    }

    void bfs(TreeNode treeNode, List<Integer> list){
        if (treeNode == null){
            list.add(null);
            return;
        }
        list.add(treeNode.getVal());
        bfs(treeNode.left, list);
        bfs(treeNode.right, list);
    }
}
