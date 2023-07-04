package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName MaxProfit1
 * @Description 买卖股票的最佳时机
 * @Author yeqiang
 * @Date 2022/7/6 8:35 AM
 * @Version 1.0
 **/
public class MaxProfit1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] curMaxProfit = new int[n];
        for (int i = 1; i < n; i++){
            if (prices[i] > prices[i-1]){
                curMaxProfit[i] = Math.max(prices[i] - prices[i - 1], curMaxProfit[i - 1] + prices[i] - prices[i - 1]);
            }else {
                curMaxProfit[i] = curMaxProfit[i - 1] + prices[i] - prices[i - 1];
            }
        }
        int maxProfit = 0;
        for (int profit:curMaxProfit){
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit1 maxProfit1 = new MaxProfit1();
        System.out.println(maxProfit1.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit1.maxProfit(new int[]{7,6,4,3,1}));
    }
}
