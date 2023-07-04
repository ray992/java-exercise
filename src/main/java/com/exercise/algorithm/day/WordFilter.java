package com.exercise.algorithm.day;

/**
 * @ClassName WordFilter
 * @Description 前缀和后缀搜索
 * @Author yeqiang
 * @Date 2022/7/14 10:55 PM
 * @Version 1.0
 **/
public class WordFilter {

    String[] words = null;
    int length = 0;

    public WordFilter(String[] words) {
        this.words = words;
        this.length = words.length;
    }

    public int f(String pref, String suff) {
      for (int i = length - 1; i >=0 ; i--){
          String word = words[i];
          if (word.startsWith(pref) && word.endsWith(suff)){
              return i;
          }
      }
      return -1;
    }
}
