package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ReverseVowels2
 * @Description 反转字符串中的元音字母
 * @Author yeqiang
 * @Date 2023/4/18 21:34
 * @Version 1.0
 **/
public class ReverseVowels2 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> characterList = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'});
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i ++){
            if (characterList.contains(s.charAt(i))){
                deque.add(i);
            }
        }
        while (!deque.isEmpty()){
            int head = deque.pollFirst();
            while (!deque.isEmpty()){
                int tail = deque.pollLast();
                char temp = chars[tail];
                chars[tail] = chars[head];
                chars[head] = temp;
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowels2 reverseVowels2 = new ReverseVowels2();
        System.out.println(reverseVowels2.reverseVowels("race car"));// race car
        //System.out.println(reverseVowels2.reverseVowels("leetcode"));
    }
}
