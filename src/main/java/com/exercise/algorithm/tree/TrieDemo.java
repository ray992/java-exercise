package com.exercise.algorithm.tree;


import com.alibaba.fastjson.JSONObject;

public class TrieDemo {

    static TrieNode root  = new TrieNode();


    public void insert(String word){
        TrieNode curNode = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (curNode.childNode[index] == null){
                curNode.childNode[index] = new TrieNode();
            }
            curNode = curNode.childNode[index];
        }
        curNode.isTail = true;
    }

    public void reverseInsert(String word){
        TrieNode curNode = root;
        for (int i = word.length() - 1; i >= 0; i --){
            int index = word.charAt(i) - 'a';
            if (curNode.childNode[index] == null){
                curNode.childNode[index] = new TrieNode();
            }
            curNode = curNode.childNode[index];
        }
    }


    public boolean query(String word){
        TrieNode curNode = root;
        for (char c:word.toCharArray()){
            int index = c - 'a';
            if (curNode.childNode[index] == null){
                return false;
            }
            curNode = curNode.childNode[index];
        }
        return curNode.isTail; // false: 前缀， true: 存在输入字符串
    }

    public static void main(String[] args) {
        TrieDemo trieDemo = new TrieDemo();
        String[] words = {"abc", "efg", "ab", "dd"};
        for (String word:words){
            trieDemo.insert(word);
        }
        System.out.println(JSONObject.toJSONString(root));
    }
}


class TrieNode {
    TrieNode[] childNode;
    boolean  isTail;

    public TrieNode() {
        this.childNode = new TrieNode[26];
    }
}