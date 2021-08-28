package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ReverseVowels
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/19 下午3:29
 * @Version 1.0
 **/
public class ReverseVowels {


    public String reverseVowels(String s) {
       char[] vowelArray = {'a','e','i','o','u','A','E','I','O','U'};
       Set<Character> characterSet = new HashSet<>();
       for (char c:vowelArray){
           characterSet.add(c);
       }
       char[] chars = s.toCharArray();
       int length = chars.length;
       char temp;
       boolean[] changed = new boolean[length];
       Arrays.fill(changed, false);
       int lastMatchIndex = length - 1;
       for (int i = 0; i < chars.length; i++){
           if (changed[i]){
               continue;
           }
           if (i >= lastMatchIndex){
               break;
           }
           if (characterSet.contains(chars[i])){
                for (int j = lastMatchIndex; j >= 0; j--){
                    if (characterSet.contains(chars[j])){
                        if (changed[j]){
                            continue;
                        }
                        temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                        changed[i] = true;
                        changed[j] = true;
                        lastMatchIndex = j -1;
                        break;
                    }
                }
           }
       }
       return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("leetcode"));
        System.out.println(reverseVowels.reverseVowels("hello"));
        System.out.println(reverseVowels.reverseVowels("race car"));
    }
}
