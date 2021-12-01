package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName FindAnagrams
 * @Description 找到字符串中所有字母异位词
 * @Author yeqiang
 * @Date 2021/11/28 下午9:48
 * @Version 1.0
 **/
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        int sn = s.length();
        int pn = p.length();
        for (int i = 0;i < s.length(); i++){
            if (i + pn > sn){
                continue;
            }
            if (compare2(s.substring(i, i+pn), p)){
                resList.add(i);
            }
        }
        return resList;
    }

    public boolean compare(String s1, String s2){
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }

    public boolean compare2(String s1, String s2){
        List<Character> characterList = new ArrayList<>();
        for (char c:s1.toCharArray()){
            characterList.add(c);
        }
        for (int i = 0; i < s2.length(); i++){
            char cur = s2.charAt(i);
            if (!characterList.contains(cur)){
                return false;
            }
            if (!characterList.remove(new Character(cur))){
                return false;
            }
        }
        return characterList.size() == 0;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
    }
}
