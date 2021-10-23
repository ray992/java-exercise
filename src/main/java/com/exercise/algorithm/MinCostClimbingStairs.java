package com.exercise.algorithm;

/**
 * @ClassName MinCostClimbingStairs
 * @Description 使用最小花费爬楼梯
 * @Author yeqiang
 * @Date 2021/10/8 下午10:42
 * @Version 1.0
 **/
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
       int[] dp = new int[n+1];
       dp[0] = dp[1] = 0;
       for (int i = 2; i <= n; i++){
           dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
       }
       return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
