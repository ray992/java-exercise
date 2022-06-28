package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName WaysToStep
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/14 下午11:43
 * @Version 1.0
 **/
public class WaysToStep {

    public int waysToStep(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, 0);
        //dp[i] = dp[i-1]+1 + dp[i-2]+2+ dp[i-3]+4
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        //1 1 1,  1 2, 2 1, 3,0
        //1 1, 2 0
        //1
        int mod = 1000000007;
        for (int i = 4; i <= n; i++){
            dp[i] = (dp[i-1]%mod+ dp[i-2]%mod+ dp[i-3]%mod)%mod;
        }
        return (int)dp[n];
    }

    public static void main(String[] args) {
        WaysToStep waysToStep =new WaysToStep();
        System.out.println(waysToStep.waysToStep(4));
        System.out.println(waysToStep.waysToStep(5));
        System.out.println(waysToStep.waysToStep(61));
        System.out.println(waysToStep.waysToStep(76));
    }
}
