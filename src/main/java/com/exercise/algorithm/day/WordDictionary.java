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
public class WordDictionary {

    private Map<Character, List<String>> dataMap;

    public WordDictionary() {
        dataMap = new HashMap<>();
    }

    public void addWord(String word) {
        char firstLetter = word.charAt(0);
        List<String> wordList = null;
        if (!dataMap.containsKey(firstLetter)){
            wordList = new ArrayList<>();
            dataMap.put(firstLetter, wordList);
        }else {
            wordList = dataMap.get(firstLetter);
        }
        wordList.add(word);
    }

    public boolean search(String word) {
        char firstLetter = word.charAt(0);
        if (!dataMap.containsKey(firstLetter) && !dataMap.containsKey('.') && firstLetter != '.'){
            return false;
        }
        List<String> allDataList = new ArrayList<>();
        if (firstLetter != '.'){
            List<String> s1 = dataMap.get(firstLetter);
            if (s1 != null){
                allDataList.addAll(s1);
            }
            List<String> s2 = dataMap.get('.');
            if (s2 != null){
                allDataList.addAll(s2);
            }
        }else {
            for (Map.Entry<Character, List<String>> map:dataMap.entrySet()){
                allDataList.addAll(map.getValue());
            }
        }
        for (String dw:allDataList){
            if (dw.equals(word)){
                return true;
            }
            if (dw.length() == word.length()){
                boolean match = true;
                for (int i = 0; i < dw.length(); i++){
                    if (dw.charAt(i) != '.' && word.charAt(i) != '.' && dw.charAt(i) != word.charAt(i)){
                        match = false;
                        break;
                    }
                }
                if (match){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad"));; // return True
        System.out.println(wordDictionary.search(".ad"));; // return True
        System.out.println(wordDictionary.search("b.."));; // return True
    }
}
