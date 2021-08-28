package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName RunningSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/28 下午3:59
 * @Version 1.0
 **/
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int lastSum = 0;
        for (int i = 0; i < n; i++){
            result[i] = lastSum + nums[i];
            lastSum = result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        RunningSum runningSum = new RunningSum();
        System.out.println(Arrays.toString(runningSum.runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum.runningSum(new int[]{1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSum.runningSum(new int[]{3, 1, 2, 10, 1})));
    }
}
