package com.exercise.algorithm;

import java.util.*;

/**
 * @ClassName VerticalTraversal
 * @Description 垂序遍历
 * @Author yeqiang
 * @Date 2021/7/31 上午9:27
 * @Version 1.0
 **/
public class VerticalTraversal {

    public Map<Integer, Map<Integer, List<Integer>>> columnMap = new LinkedHashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null){
            return resultList;
        }
        traverse(root, 0, 0, 0);
        TreeMap<Integer, Map<Integer, List<Integer>>> orderMap = new TreeMap<>(columnMap);
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> map:orderMap.entrySet()){
            Integer col = map.getKey();
            Map<Integer, List<Integer>> rowMap = map.getValue();
            TreeMap<Integer, List<Integer>> rowOrderMap = new TreeMap<>(rowMap);
            List<Integer> actualList = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> _map:rowOrderMap.entrySet()){
                Integer row = _map.getKey();
                List<Integer> valList = _map.getValue();
                Collections.sort(valList);
                for (Integer val:valList){
                    actualList.add(val);
                }
            }
            resultList.add(actualList);
        }
        return resultList;
    }

    public void traverse(TreeNode treeNode, int row, int col, int direction){
        if (treeNode == null){
            return;
        }
        int tempRow = 0;
        int tempColumn = 0;
        if (direction == 1){
            tempRow = row +1;
            tempColumn = col - 1;
        }else if (direction == 2){
            tempRow = row +1;
            tempColumn = col + 1;
        }
        if (columnMap.containsKey(tempColumn)){
            Map<Integer, List<Integer>> map = columnMap.get(tempColumn);
            if (map.containsKey(tempRow)){
                map.get(tempRow).add(treeNode.val);
            }else {
                List<Integer> nodeList = new ArrayList<>();
                nodeList.add(treeNode.val);
                map.put(tempRow, nodeList);
            }
        }else {
            Map<Integer, List<Integer>> map = new LinkedHashMap<>();
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(treeNode.val);
            map.put(tempRow, nodeList);
            columnMap.put(tempColumn, map);
        }
        traverse(treeNode.left, tempRow, tempColumn, 1);
        traverse(treeNode.right, tempRow, tempColumn, 2);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = null;
        rootLeft.right = null;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        List<List<Integer>> resultList = verticalTraversal.verticalTraversal(root);
        System.out.println(resultList);
    }
}
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}