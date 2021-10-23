package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WordDictionary
 * @Description 添加与搜索单词
 * @Author yeqiang
 * @Date 2021/10/19 上午10:31
 * @Version 1.0
 **/
public class WordDictionary_back {

    private Map<Integer, List<String>> dictionaryMap;

    public WordDictionary_back() {
        dictionaryMap = new HashMap<>();
    }

    public void addWord(String word) {
        int length = word.length();
        List<String> dataList = null;
        if (dictionaryMap.containsKey(length)){
            dataList = dictionaryMap.get(length);
        }else {
            dataList = new ArrayList<>();
            dictionaryMap.put(length, dataList);
        }
        dataList.add(word);
    }

    public boolean search(String word) {
       int n = word.length();
       if (!dictionaryMap.containsKey(n)){
           return false;
       }
       List<String> dataList = dictionaryMap.get(n);
       for (int i = 0; i < dataList.size(); i++){
           String curData = dataList.get(i);
           boolean matchStatus = true;
           for (int j = 0; j < n; j++){
               if (word.charAt(j) != '.' && word.charAt(j) != curData.charAt(j)){
                   matchStatus = false;
                   break;
               }
           }
           if (matchStatus){
               return true;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        WordDictionary_back wordDictionary = new WordDictionary_back();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad"));; // return True
        System.out.println(wordDictionary.search(".ad"));; // return True
        System.out.println(wordDictionary.search("b.."));; // return True
    }
}
