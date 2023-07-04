package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName IsIsomorphic
 * @Description 同构字符串
 * @Author yeqiang
 * @Date 2022/7/4 8:53 AM
 * @Version 1.0
 **/
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Integer> sCharacterIntegerMap = new HashMap<>();
        Map<Character, Integer> tCharacterIntegerMap = new HashMap<>();
        Integer ii = 1;
        for (int i = 0; i < n; i++){
           char c1 = s.charAt(i);
           char c2 = t.charAt(i);
           Integer i1 = sCharacterIntegerMap.getOrDefault(c1, ii);
           Integer i2 = tCharacterIntegerMap.getOrDefault(c2, ii);
           sCharacterIntegerMap.put(c1, i1);
           tCharacterIntegerMap.put(c2, i2);
           if (!Objects.equals(i1, i2)){
               return false;
           }
           ii++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        System.out.println(isIsomorphic.isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic.isIsomorphic("foo", "bar"));
    }
}
