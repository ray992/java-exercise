package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StringMatching
 * @Description 数组中的字符串匹配
 * @Author yeqiang
 * @Date 2022/8/6 2:48 PM
 * @Version 1.0
 **/
public class StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> resultList = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if (words[j].contains(words[i])){
                    resultList.add(words[i]);
                    break;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        StringMatching stringMatching = new StringMatching();
        //System.out.println(stringMatching.stringMatching(new String[]{"mass","as","hero","superhero"}));
        System.out.println(stringMatching.stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }
}
