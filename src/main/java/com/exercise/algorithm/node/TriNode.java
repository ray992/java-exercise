package com.exercise.algorithm.node;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName TriNode
 * @Description 前缀树/字典树, 空间换时间
 * @Author yeqiang
 * @Date 2023/3/29 07:40
 * @Version 1.0
 **/
public class TriNode {

    Node root = new Node(26);



    public void insert(String content){
        Node node = root;
        char[] chars = content.toCharArray();
        for (char c:chars){
            int i = c - 'a';
            Node child = node.children[i];
            if (child == null){
                child = new Node(26);
            }
            node.children[i] = child;
        }
        node.isEnd = true;
    }

    public boolean query(String content){
        Node node = root;
        char[] chars = content.toCharArray();
        for (char c:chars){
            int i = c - 'a';
            if (node.children[i] == null){
                return false;
            }
            node = node.children[i];
        }
        return node.isEnd;
    }


    public static void main(String[] args) {
        TriNode triNode = new TriNode();
        String[] words = {"abcd", "cd", "efg", "bc"};
        for (String word:words){
            triNode.insert(word);
        }
        System.out.println(JSON.toJSONString(triNode.root));
        System.out.println(triNode.query("c"));
        System.out.println(triNode.query("cd"));
        System.out.println(triNode.query("abc"));
    }



    static class Node {

        private boolean isEnd;

        private Node[] children;

        private Node() {
        }

        public Node(int length) {
            this.children = new Node[length];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Node[] getChildren() {
            return children;
        }

        public void setChildren(Node[] children) {
            this.children = children;
        }
    }

}
