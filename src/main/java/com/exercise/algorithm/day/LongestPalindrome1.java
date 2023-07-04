package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestPalindrome1
 * @Description 最长回文串
 * @Author yeqiang
 * @Date 2022/7/6 9:20 AM
 * @Version 1.0
 **/
public class LongestPalindrome1 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c:s.toCharArray()){
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0)+1);
        }
        int longestCount = 0;
        boolean onlyOne = false;
        for (Map.Entry<Character, Integer> map:characterIntegerMap.entrySet()){
            Integer count = map.getValue();
            if ((count & 1) == 1){
                if (!onlyOne){
                    longestCount += count;
                    onlyOne = true;
                }else {
                    longestCount += count -1;
                }
            }else {
                longestCount += count;
            }
        }
        return longestCount;
    }

    public static void main(String[] args) {
        LongestPalindrome1 longestPalindrome1 = new LongestPalindrome1();
        System.out.println(longestPalindrome1.longestPalindrome("a"));
    }
}
