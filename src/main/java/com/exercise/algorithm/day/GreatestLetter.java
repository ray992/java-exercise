package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName GreatestLetter
 * @Description 兼具大小写的最好英文字母
 * @Author yeqiang
 * @Date 2023/1/27 17:46
 * @Version 1.0
 **/
public class GreatestLetter {


    public static String greatestLetter(String s) {
         char lowerCharacter = 'a';
        Set<Character> lowerSet = new HashSet<>();
        for (int i = 0; i < 26; i++){
            lowerSet.add((char) (lowerCharacter + i));
        }
        Character result = null;
        Set<Character> characterSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char curChar = chars[i];
            if (!characterSet.contains(curChar)){
                characterSet.add(curChar);
                char c1 = (char) (curChar + 32);
                char c2 = (char) (curChar - 32);
                if (characterSet.contains(c1) || characterSet.contains(c2)){
                    if (lowerSet.contains(curChar)){
                        curChar -= 32;
                    }
                    if (result == null || curChar > result){
                        result = curChar;
                    }
                }
            }
        }
        return result == null ? "" : result + "";
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }
}
