package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaxLevelSum
 * @Description 最大层内元素
 * @Author yeqiang
 * @Date 2022/7/31 10:06 AM
 * @Version 1.0
 **/
public class MaxLevelSum {

    Map<Integer, Integer> layerMap = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        postOrder(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int minLayer = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> map:layerMap.entrySet()){
            int curLayer = map.getKey();
            int curSum = map.getValue();
            if (curSum > maxSum){
                minLayer = curLayer;
                maxSum = curSum;
            }else if (curSum == maxSum){
                if (curLayer < minLayer){
                    minLayer = curLayer;
                }
            }
        }
        return minLayer;
    }

    public void postOrder(TreeNode treeNode, int layer){
        if (treeNode == null){
            return;
        }
        layerMap.put(layer, layerMap.getOrDefault(layer, 0)+ treeNode.val);
        if (treeNode.left != null){
            postOrder(treeNode.left, layer + 1);
        }
        if (treeNode.right != null){
            postOrder(treeNode.right, layer + 1);
        }
    }

}
