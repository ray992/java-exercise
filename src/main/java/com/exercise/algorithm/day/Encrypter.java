package com.exercise.algorithm.day;

import lombok.var;

import java.util.*;

/**
 * @ClassName Encrypter
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/3 11:39 AM
 * @Version 1.0
 **/
public class Encrypter {

    String[] map = new String[26];
    Map<String, Integer> cnt = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (var i = 0; i < keys.length; i++){
            map[keys[i] - 'a'] = values[i];
        }
        for (var s: dictionary){
            var  e  = encrypt(s);
            cnt.put(e, cnt.getOrDefault(e, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        var res = new  StringBuilder();
        for (var i = 0; i < word1.length(); i++){
            var s = map[word1.charAt(i) - 'a'];
            if (s == null){
                continue;
            }
            res.append(s);
        }
        return res.toString();
    }

    public int decrypt(String word2) {
      return cnt.getOrDefault(word2, 0);
    }
}
