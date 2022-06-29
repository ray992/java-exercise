package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName SmallestRangeI
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/30 8:40 AM
 * @Version 1.0
 **/
public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        int diff = max - min;
        if (diff <= k + k){
            return 0;
        }
        return diff - k -k;
    }

    public static void main(String[] args) {
        SmallestRangeI smallestRangeI = new SmallestRangeI();
        System.out.println(smallestRangeI.smallestRangeI(new int[]{1}, 0));
        System.out.println(smallestRangeI.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
