package com.exercise.algorithm.day;

/**
 * @ClassName MergeAlternately
 * @Description 交替字符串
 * @Author yeqiang
 * @Date 2023/4/16 18:45
 * @Version 1.0
 **/
public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = Math.max(word1.length(), word2.length());
        for (int i = 0; i < n; i++){
            if (i < word1.length()){
                result.append(word1.charAt(i));
            }
            if (i < word2.length()){
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MergeAlternately mergeAlternately = new MergeAlternately();
        System.out.println(mergeAlternately.mergeAlternately("aaaaabc", "abcccc"));
    }
}
