package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MaxScoreSightseeingPair
 * @Description 最佳观光组合
 * @Author yeqiang
 * @Date 2021/9/27 下午11:25
 * @Version 1.0
 **/
public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int s, t ;
        int max = -1;
        for (int i = 0; i < n; i++){
            s = values[i];
            for (int j = i+1; j < n; j++){
                t = values[j];
                if (s + t + i - j > max){
                    max = s + t + i - j;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxScoreSightseeingPair maxScoreSightseeingPair = new MaxScoreSightseeingPair();
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{1,2}));

        Set<String> appPackageList = new HashSet<>();
        appPackageList.add("AB");
        appPackageList.add("CD");
        appPackageList.add("EF");
        System.out.println(appPackageList.toString());
    }
}
