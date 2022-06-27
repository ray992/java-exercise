package com.exercise.algorithm.top;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            if (characterIntegerMap.containsKey(s.charAt(i))){
                left = Math.max(left, characterIntegerMap.get(s.charAt(i)) + 1);
            }
            characterIntegerMap.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring_3 = new LengthOfLongestSubstring_3();
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_3.lengthOfLongestSubstring("aaaaa"));
    }
}
