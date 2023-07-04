package com.exercise.algorithm.day;

/**
 * @ClassName MinCostClimbingStairs1
 * @Description 使用最小花费爬楼梯
 * @Author yeqiang
 * @Date 2022/7/7 5:32 PM
 * @Version 1.0
 **/
public class MinCostClimbingStairs1 {

    public int minCostClimbingStairs(int[] cost) {
       for (int i = 2; i < cost.length; i++){
           cost[i] += Math.min(cost[i - 1], cost[i - 2]);
       }
       return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] costs = new int[n + 1];
        costs[0] = 0;
        costs[1] = 0;
        for (int i = 2; i <= n; i++){
            costs[i] = Math.min(costs[i - 1] + cost[i -1], costs[i - 2]+ cost[i -2]);
        }
        return costs[n];
    }

    public static void main(String[] args) {

    }
}
