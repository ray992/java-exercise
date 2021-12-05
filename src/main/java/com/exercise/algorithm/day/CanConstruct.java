package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CanConstruct
 * @Description 赎金信
 * @Author yeqiang
 * @Date 2021/12/4 下午4:21
 * @Version 1.0
 **/
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] m = magazine.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c:m){
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }
        for (char r:ransomNote.toCharArray()){
            if (!countMap.containsKey(r)){
                return false;
            }
            if (countMap.get(r) <= 0){
                return false;
            }
            countMap.put(r, countMap.get(r) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        System.out.println(canConstruct.canConstruct("a", "b"));
        System.out.println(canConstruct.canConstruct("aa", "ab"));
        System.out.println(canConstruct.canConstruct("aa", "aab"));
    }
}
