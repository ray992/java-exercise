package com.exercise.algorithm.day;

import java.util.Arrays;

public class maxProduct1 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1 ) * (nums[n - 2] - 1 );
    }
}
