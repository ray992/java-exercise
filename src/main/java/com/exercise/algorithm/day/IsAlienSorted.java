package com.exercise.algorithm.day;

import java.util.*;

public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer>  characterIntegerMap = new HashMap<>();
        int orderNum = 11;
        for (char c:order.toCharArray()){
            characterIntegerMap.put(c, orderNum);
            orderNum ++;
        }
        int n = words.length;
        List<String> originOrderList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String curWord = words[i];
            StringBuilder changeSB = new StringBuilder();
            for (int r = 0 ; r < curWord.length(); r++){
                changeSB.append(characterIntegerMap.get(curWord.charAt(r)));
            }
            originOrderList.add(changeSB.toString());
        }
        List<String> dicOrderList = new ArrayList<>(originOrderList);
        Collections.sort(dicOrderList);
        for (int i = 0; i < n; i++){
            if (!Objects.equals(originOrderList.get(i), dicOrderList.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
