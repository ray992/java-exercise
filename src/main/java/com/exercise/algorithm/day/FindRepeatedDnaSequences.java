package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindRepeatedDnaSequences
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/8 下午7:22
 * @Version 1.0
 **/
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resultList = new ArrayList<>();
        Set<String> duplicateSet = new HashSet<>();
        int length = s.length();
        if (length > 10){
            int i = 0;
            int j = i + 10;
            do {
                String subString = s.substring(i, j);
                int index = s.substring(i+1).indexOf(subString);
                if (index > -1 && duplicateSet.add(subString)) {
                    resultList.add(subString);
                }
                i++;
                j = i + 10;
            } while (j <= length);
        }
        return resultList;
    }

    public List<String> findRepeatedDnaSequences2(String s){
        Map<String, Integer> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i <= length - 10; i++){
            String subString = s.substring(i, i+10);
            map.put(subString, map.getOrDefault(subString, 0)+1);
            if (map.get(subString) == 2){
                resultList.add(subString);
            }
        }
        return resultList;
    }



    public static void main(String[] args) {
        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences2("AAAAAAAAAAAAA"));
    }
}
