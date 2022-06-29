package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FindFrequentTreeSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/19 9:07 PM
 * @Version 1.0
 **/
public class FindFrequentTreeSum {

    int maxSumChildTreeNodeTimes = 0;

    Map<Integer, Integer> sumMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> maxSumList = new ArrayList<>();
        sumMap.forEach((key, val) ->{
            if (val == maxSumChildTreeNodeTimes){
                maxSumList.add(key);
            }
        });
        int[] res = new int[maxSumList.size()];
        for (int i = 0; i < maxSumList.size(); i++){
            res[i] = maxSumList.get(i);
        }
        return res;
    }

    public int dfs(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int sum = treeNode.val + dfs(treeNode.left) + dfs(treeNode.right);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);
        maxSumChildTreeNodeTimes = Math.max(maxSumChildTreeNodeTimes, sumMap.get(sum));
        return sum;
    }
}
