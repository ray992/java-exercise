package com.exercise.algorithm.day;

/**
 * @ClassName MinFlipsMonoIncr
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/11 11:13 PM
 * @Version 1.0
 **/
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        int right = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                right ++;
            }
        }
        int left = 0;
        int sum = left + right;
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                --right;
            }else {
                left++;
            }
            sum = Math.min(sum, left + right);
        }
        return sum;
    }
}
