package com.exercise.algorithm.day;

import java.util.*;

/**
电话号码的字母组合
*/
public class LetterCombinations {

    Map<Character, String> letterCharacterMap = new HashMap<>();

    {
        letterCharacterMap.put('2', "abc");
        letterCharacterMap.put('3', "def");
        letterCharacterMap.put('4', "ghi");
        letterCharacterMap.put('5', "jkl");
        letterCharacterMap.put('6', "mno");
        letterCharacterMap.put('7', "pqrs");
        letterCharacterMap.put('8', "tuv");
        letterCharacterMap.put('9', "wxyz");
    }

    public List<String> resultList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return resultList;
        }
        combination("", digits, 0, new StringBuilder());
        return resultList;
    }

    public void combination(String conString, String digits, int index, StringBuilder stringBuilder){
        if (index >= digits.length()){
            resultList.add(conString);
            return;
        }
        String characters = letterCharacterMap.get(digits.charAt(index));
        for (int i = 0; i < characters.length(); i++){
            stringBuilder.append(characters.charAt(i));
            combination(stringBuilder.toString(), digits, index+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()  - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }



}
