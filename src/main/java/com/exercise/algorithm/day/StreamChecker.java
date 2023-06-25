package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class StreamChecker {

    /**
     *
     * logo
     * 学习
     * 题库
     * 竞赛
     * 讨论
     * 求职
     * 商店
     * Plus 会员
     * 2
     *
     * 题目描述
     * 评论 (237)
     * 题解 (244)
     * 提交记录
     * 1032. 字符流
     * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
     *
     * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
     *
     * 按下述要求实现 StreamChecker 类：
     *
     * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
     * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
     *
     *
     * 示例：
     *
     * 输入：
     * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
     * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
     * 输出：
     * [null, false, false, false, true, false, true, false, false, false, false, false, true]
     *
     * 解释：
     * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
     * streamChecker.query("a"); // 返回 False
     * streamChecker.query("b"); // 返回 False
     * streamChecker.query("c"); // 返回n False
     * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
     * streamChecker.query("e"); // 返回 False
     * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
     * streamChecker.query("g"); // 返回 False
     * streamChecker.query("h"); // 返回 False
     * streamChecker.query("i"); // 返回 False
     * streamChecker.query("j"); // 返回 False
     * streamChecker.query("k"); // 返回 False
     * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
     *
     *
     * 提示：
     *
     * 1 <= words.length <= 2000
     * 1 <= words[i].length <= 200
     * words[i] 由小写英文字母组成
     * letter 是一个小写英文字母
     * 最多调用查询 4 * 104 次
     * 通过次数17,991提交次数31,982
     * 请问您在哪类招聘中遇到此题？
     * 贡献者
     * LeetCode
     * 1032/2976
     *
     * 智能模式
     *
     * 模拟面试
     *
     *
     *
     *
     *
     *
     * 12345678910111213141516
     * class StreamChecker {
     *
     *     public StreamChecker(String[] words) {
     *
     *     }
     *
     *     public boolean query(char letter) {
     *
     *     }
     * }
     *
     * 控制台
     * 贡献
     * 搜索题目
     * 简单
     * @param words
     */

    public StreamChecker(String[] words) {
        for (String word:words){
            Node node = root;
            int length = word.length();
            for (int i = length - 1; i >= 0; i --){
                int index = word.charAt(i) - c;
                if (node.children[index] == null){
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.isEnd =  true;
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        int length = list.size();
        Node node = root;
        for (int i = length - 1; i >= 0; i --){
            int index = list.get(i) - c;
            Node childrenNode = node.children[index];
            if (childrenNode == null){
                return false;
            }
            if (childrenNode.isEnd){
                return true;
            }
            node = childrenNode;
        }
        return false;
    }

    Node root = new Node();
    List<Character> list = new ArrayList<>();
    char c = 'a';
    static class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }

    // ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
    }
}

