package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MagicDictionary
 * @Description 实现一个魔法字典
 * @Author yeqiang
 * @Date 2022/7/11 8:48 AM
 * @Version 1.0
 **/
public class MagicDictionary {

    Set<String> dicSet = null;

    public MagicDictionary() {
        dicSet = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        dicSet.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        for (String dic:dicSet){
            if (dic.length() != searchWord.length()){
                continue;
            }
            int disMatchCount = 0;
            for (int i = 0; i < searchWord.length(); i++){
                if (searchWord.charAt(i) != dic.charAt(i)){
                    disMatchCount++;
                }
                if (disMatchCount > 1){
                    break;
                }
            }
            if (disMatchCount == 1){
                return true;
            }
        }
        return false;
    }
}
