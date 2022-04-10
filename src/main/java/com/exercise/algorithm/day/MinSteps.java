package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

public class MinSteps {

    public int minSteps(String s, String t) {
        Map<Character, Integer> sCountMap = new HashMap();
        Map<Character, Integer> tCountMap = new HashMap<>();
        for (char c:s.toCharArray()){
            sCountMap.put(c, sCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c:t.toCharArray()){
            tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
        }
        char[] chars = new char[26];
        for (int i = 0; i < 26; i++){
            chars[i] = (char) ('a' +i);
        }
        Map<Character, Integer> addSCountMap = new HashMap();
        Map<Character, Integer> addTCountMap = new HashMap<>();
        for (char c:chars){
            Integer s1 = sCountMap.get(c);
            Integer t1 = tCountMap.get(c);
            if (s1 == null && t1 == null){
                continue;
            }
            int n = 0;
            if (s1 == null){
                n = t1;
            }else if (t1 == null){
                n = s1;
            }else {
                n = Math.max(t1, s1);
            }
            addSCountMap.put(c, (n - (s1 == null ? 0 : s1)));
            addTCountMap.put(c, (n - (t1 == null ? 0 : t1)));
        }
        int step = 0;
        if (addSCountMap.size() > 0){
            for (Map.Entry<Character, Integer> map:addSCountMap.entrySet()){
                step+=map.getValue();
            }
            for (Map.Entry<Character, Integer> map:addTCountMap.entrySet()){
                step+=map.getValue();
            }
        }
        return step;
    }

    public static void main(String[] args) {
        MinSteps minSteps = new MinSteps();
        System.out.println(minSteps.minSteps("leetcode", "coats"));
        System.out.println(minSteps.minSteps("night", "night"));
    }
}
