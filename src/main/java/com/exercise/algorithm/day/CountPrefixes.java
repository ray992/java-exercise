package com.exercise.algorithm.day;

/**
 * @ClassName CountPrefixes
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/30 10:30 PM
 * @Version 1.0
 **/
public class CountPrefixes {

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (int i = 0; i < words.length; i++){
           int index = s.indexOf(words[i]);
           if (index == 0){
               count++;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrefixes countPrefixes = new CountPrefixes();
        System.out.println(countPrefixes.countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc"));
        System.out.println(countPrefixes.countPrefixes(new String[]{"a","a"}, "aa"));
    }
}
