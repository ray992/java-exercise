package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName TopKFrequent
 * @Description 前K个高频单词
 * @Author yeqiang
 * @Date 2022/7/9 10:07 AM
 * @Version 1.0
 **/
public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> resultList = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word:words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> frequentList = new ArrayList<>();
        TreeMap<Integer, List<String>> sameFrequentMap = new TreeMap<>();
        wordMap.forEach((key, value) ->{
            List<String> wordList =  sameFrequentMap.getOrDefault(value, new ArrayList<>());
            wordList.add(key);
            sameFrequentMap.put(value, wordList);
            if (!frequentList.contains(value)){
                frequentList.add(value);
            }
        });
        Collections.sort(frequentList);
       int n = frequentList.size();
       int count = 0;
       for (int i = n - 1; i >= 0; i--){
           if (count >= k) {
               break;
           }
           List<String> wordList = sameFrequentMap.get(frequentList.get(i));
           Collections.sort(wordList);
           for (String s : wordList) {
               resultList.add(s);
               count++;
               if (count >= k) {
                   break;
               }
           }
       }
       return resultList;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        //System.out.println(topKFrequent.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
        //System.out.println(topKFrequent.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
        System.out.println(topKFrequent.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 3));
    }
}
