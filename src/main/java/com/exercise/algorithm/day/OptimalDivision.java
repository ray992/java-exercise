package com.exercise.algorithm.day;

/**
 * 最优除法
 */
public class OptimalDivision {

    public String optimalDivision(int[] nums) {
        StringBuilder result = new StringBuilder();
        int n = nums.length;
        if (n == 1){
            return result.append(nums[0]).toString();
        }
        if (n == 2){
            return result.append(nums[0]).append("/").append(nums[1]).toString();
        }
        for (int i = 0; i < n; i++){
            if (i < n - 1){
                if (i == 1){
                    result.append("(");
                }
                result.append(nums[i]).append("/");
            }else {
                result.append(nums[i]).append(")");
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        OptimalDivision optimalDivision = new OptimalDivision();
        System.out.println(optimalDivision.optimalDivision(new int[]{1000, 100, 10, 2}));
    }
}
