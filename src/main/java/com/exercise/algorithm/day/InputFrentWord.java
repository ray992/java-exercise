package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName InputFrentWord
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/21 4:13 PM
 * @Version 1.0
 **/
public class InputFrentWord {

    public List<String> inputTop10FrentWord(String[] words){
        //结果集合
        List<String> resultList = new ArrayList<>();
        //输出出现的次数
        List<Integer> countList = new ArrayList<>();
        //统计每个词出现的次数
        Map<String, Integer> countMap = new HashMap<>();
        for (String word:words){
            countMap.put(word, countMap.getOrDefault(word, 0)+1);
        }
        //相同次数出现的单词
        Map<Integer, List<String>> sameCountWordMap = new HashMap<>();
        for (Map.Entry<String , Integer> map:countMap.entrySet()){
            Integer count = map.getValue();
            String word = map.getKey();
            if (!countList.contains(count)){
                countList.add(count);
            }
            List<String> wordList = sameCountWordMap.getOrDefault(count, new ArrayList<>());
            wordList.add(word);
            sameCountWordMap.put(count, wordList);
        }
        Collections.sort(countList);
        int topCount = 0;
        for (int i = countList.size() - 1; i >= 0; i--){
            if (topCount >= 10){
                break;
            }
            List<String> wordList = sameCountWordMap.get(countList.get(i));
            for (String word:wordList){
                if (topCount >= 10){
                    break;
                }
                resultList.add(word);
                topCount++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
