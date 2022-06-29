package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FindAndReplacePattern
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/12 11:36 AM
 * @Version 1.0
 **/
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resultList = new ArrayList<>();
        Map<Character, Integer>  patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++){
            if (patternMap.containsKey(pattern.charAt(i))){
                continue;
            }
            patternMap.put(pattern.charAt(i), i);
        }
        StringBuilder patternStringBuild = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++){
            int index = patternMap.get(pattern.charAt(i));
            patternStringBuild.append(index).append(i);
        }
        String patternString = patternStringBuild.toString();
        Map<Character, Integer>  wordMap = new HashMap<>();
        for (String word:words){
            for (int i = 0; i < word.length(); i++){
                if (wordMap.containsKey(word.charAt(i))){
                    continue;
                }
                wordMap.put(word.charAt(i), i);
            }
            StringBuilder wordStringBuild = new StringBuilder();
            for (int i = 0; i < word.length(); i++){
                int index = wordMap.get(word.charAt(i));
                wordStringBuild.append(index).append(i);
            }
            if (patternString.equals(wordStringBuild.toString())){
                resultList.add(word);
            }
            wordMap.clear();
        }
        return resultList;
    }

    public static void main(String[] args) {
        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
        System.out.println(findAndReplacePattern.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
