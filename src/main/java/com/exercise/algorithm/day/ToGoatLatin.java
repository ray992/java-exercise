package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ToGoatLatin
 * @Description 山羊拉丁文
 * @Author yeqiang
 * @Date 2022/4/21 9:47 AM
 * @Version 1.0
 **/
public class ToGoatLatin {

    public String toGoatLatin(String sentence) {
        List<Character> yuanYinList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split("[ ]");
        String  commonSuffix = "ma";
        String sa = "a";
        for (String word:words){
            char sc = word.toLowerCase().charAt(0);
            if (yuanYinList.contains(sc)){
                stringBuilder.append(word).append(commonSuffix).append(sa).append(" ");
            }else {
                stringBuilder.append(word.substring(1)).append(word.charAt(0)).append(commonSuffix).append(sa).append(" ");
            }
            sa = sa.concat("a");
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" "));
    }

    public static void main(String[] args) {
        ToGoatLatin toGoatLatin = new ToGoatLatin();
        System.out.println(toGoatLatin.toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
