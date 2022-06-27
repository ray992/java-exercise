package com.exercise.algorithm.day;

import java.util.Arrays;

public class MinMoves2 {

    public int minMoves2(int[] nums){
        Arrays.sort(nums);
        int left = 0,  right = nums.length - 1;
        int ans = 0;
        while (left < right){
            ans += nums[right] - nums[left];
            left ++;
            right --;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinMoves2 minMoves2 = new MinMoves2();
        System.out.println(minMoves2.minMoves2(new int[]{1,2,3,4}));
        System.out.println(minMoves2.minMoves2(new int[]{1,10,2,9}));
    }
}
