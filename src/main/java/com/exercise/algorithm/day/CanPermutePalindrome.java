package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CanPermutePalindrome
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/18 上午9:30
 * @Version 1.0
 **/
public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean oddStatus = true;
        if (n % 2 == 0){
            oddStatus = false;
        }
        Map<Character, Integer> characterSet = new HashMap<>();
        Set<Character> singleCharacter = new HashSet<>();
        for (int i = 0; i < chars.length; i++){
            char curChar = chars[i];
            if (characterSet.containsKey(curChar)){
                Integer num = characterSet.get(curChar);
                if (num + 1 == 2){
                    singleCharacter.remove(curChar);
                    characterSet.remove(curChar);
                }
            }else {
                characterSet.put(curChar, 1);
                singleCharacter.add(curChar);
            }
        }
        if (singleCharacter.size() > 1){
            return false;
        }
        return oddStatus || singleCharacter.size() <= 0;
    }

    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        System.out.println(canPermutePalindrome.canPermutePalindrome("aaa"));
        System.out.println(canPermutePalindrome.canPermutePalindrome("code"));
    }
}
