package com.exercise.algorithm.day;

public class MaximumDifference {

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (nums[j] > nums[i] && nums[j] - nums[i] > maxDiff){
                    maxDiff = nums[j] - nums[i];
                }
            }
        }
        return maxDiff > Integer.MIN_VALUE ? maxDiff : -1;
    }

    public static void main(String[] args) {
        MaximumDifference maximumDifference = new MaximumDifference();
        System.out.println(maximumDifference.maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(maximumDifference.maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(maximumDifference.maximumDifference(new int[]{1, 5, 2, 10}));
    }
}
