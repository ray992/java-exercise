package com.exercise.algorithm.day;

/**
 * @ClassName FindMaxAverage
 * @Description 子数组最大平均数
 * @Author yeqiang
 * @Date 2022/5/5 9:43 AM
 * @Version 1.0
 **/
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        int l = 0;
        int r = 0;
        double maxAverage = -Double.MAX_VALUE;
        for (; r < n; r++){
            sum += nums[r];
            while (r - l + 1 == k && l <= r){
                double curAverage = sum / (r - l + 1);
                maxAverage = Math.max(maxAverage, curAverage);
                sum -= nums[l++];
            }
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        //System.out.println(findMaxAverage.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        //System.out.println(findMaxAverage.findMaxAverage(new int[]{5}, 1));
        System.out.println(findMaxAverage.findMaxAverage(new int[]{-1}, 1));
    }
}
