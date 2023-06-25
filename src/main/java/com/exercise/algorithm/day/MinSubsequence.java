package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递增顺序的最小子序列
 */
public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        Arrays.sort(nums);
        int childSum = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            childSum += nums[i];
            resultList.add(nums[i]);
            if (childSum > sum - childSum){
                break;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        MinSubsequence minSubsequence = new MinSubsequence();
        System.out.println(minSubsequence.minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(minSubsequence.minSubsequence(new int[]{4, 4, 7, 7, 6}));
        System.out.println(minSubsequence.minSubsequence(new int[]{6}));
    }
}
