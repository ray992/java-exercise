package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ReplaceWords
 * @Description 单词替换
 * @Author yeqiang
 * @Date 2022/7/7 8:49 AM
 * @Version 1.0
 **/
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split("[ ]");
        for (String word:words){
            int minLength = 1001;
            String temp = word;
            for (String dic:dictionary){
                if (word.startsWith(dic)){
                    if (minLength > dic.length()){
                        minLength = dic.length();
                        temp = dic;
                    }
                }
            }
            stringBuilder.append(temp).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" "));
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split("[ ]");
        for (String word:words){
            boolean hitStatus = false;
            for (String dic:dictionary){
                if (word.startsWith(dic)){
                    hitStatus = true;
                    stringBuilder.append(dic).append(" ");
                    break;
                }
            }
            if (!hitStatus){
                stringBuilder.append(word).append(" ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(" "));
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dicList = new ArrayList<>();
        dicList.add("cat");
        dicList.add("bat");
        dicList.add("rat");
        System.out.println(replaceWords.replaceWords2(dicList, "the cattle was rattled by the battery"));
    }
}
