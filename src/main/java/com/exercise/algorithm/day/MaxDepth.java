package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MaxDepth
 * @Description N叉树的最大深度
 * @Author yeqiang
 * @Date 2021/11/21 下午9:40
 * @Version 1.0
 **/
public class MaxDepth {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> children = root.children;
        if (children == null){
            return 0;
        }
        for (Node child : children) {
            int childDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }
        return maxChildDepth + 1;

    }


    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node3 = new Node(3, new ArrayList<>());
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node1 = new Node(1, new ArrayList<>());
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children.add(node5);
        node3.children.add(node6);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(node1));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}