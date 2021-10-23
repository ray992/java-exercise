package com.exercise.algorithm;

/**
 * @ClassName NumWays
 * @Description 传递信息
 * @Author yeqiang
 * @Date 2021/10/8 下午11:08
 * @Version 1.0
 **/
public class NumWays {

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    int N = 1000000007;

    public int numWays(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1]%N + dp[i-2]%N;
        }
        return dp[n]%N;
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(0));
        System.out.println(numWays.numWays(2));
        System.out.println(numWays.numWays(7));
    }
}
