package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName Codec
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/11 9:24 AM
 * @Version 1.0
 **/
public class Codec {

    public void postOrder(TreeNode treeNode, List<Integer> list){
        if (treeNode == null){
            return;
        }
        postOrder(treeNode.left, list);
        postOrder(treeNode.right, list);
        list.add(treeNode.val);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //后序遍历
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()){
            return null;
        }
        String[] arr = data.split("[, ]");
        Deque<Integer> stack = new ArrayDeque<>();
        int length = arr.length;
        for (int i = 0; i < length; i++){
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    public TreeNode construct(int lower, int upper, Deque<Integer> stack){
        if (stack.isEmpty() || stack.peekFirst() < lower || stack.peekFirst() > upper){
            return null;
        }
        int val = stack.poll();
        TreeNode treeNode = new TreeNode(val);
        treeNode.right = construct(val, upper, stack);
        treeNode.left = construct(lower, val, stack);
        return treeNode;
    }


    public static void main(String[] args) {

    }
}
