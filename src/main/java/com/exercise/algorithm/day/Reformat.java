package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class Reformat {

    public String reformat(String s) {
        List<Integer> characterPosList = new ArrayList<>();
        List<Integer> digitPosList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                digitPosList.add(i);
            }else if (Character.isAlphabetic(s.charAt(i))){
                characterPosList.add(i);
            }
        }
        int l1 = characterPosList.size();
        int l2 = digitPosList.size();
        if (Math.abs(l1 - l2) > 1){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        if (l1 >= l2){
            while (i < l1){
                stringBuilder.append(s.charAt(characterPosList.get(i)));
                i++;
                if (j < l2){
                    stringBuilder.append(s.charAt(digitPosList.get(j)));
                    j++;
                }
            }
        }else {
            while (i < l2){
                stringBuilder.append(s.charAt(digitPosList.get(i)));
                i++;
                if (j < l1){
                    stringBuilder.append(s.charAt(characterPosList.get(j)));
                    j++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        System.out.println(reformat.reformat("a0b1c2"));
        System.out.println(reformat.reformat("leetcode"));
        System.out.println(reformat.reformat("1229857369"));
        System.out.println(reformat.reformat("covid2019"));
        System.out.println(reformat.reformat("ab123"));
    }
}
