package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName CheckPermutation
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午9:40
 * @Version 1.0
 **/
public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
       char[] c1 = s1.toCharArray();
       char[] c2 = s2.toCharArray();
       if (c1.length != c2.length){
           return false;
       }
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        while (i < c1.length){
            if (c1[i] != c2[i]){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.CheckPermutation("abc", "cba"));
        System.out.println(checkPermutation.CheckPermutation("abc", "bad"));
    }
}
