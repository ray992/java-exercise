package com.exercise.algorithm;

/**
 * @ClassName MaxProfit
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/8 下午9:12
 * @Version 1.0
 **/
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int revenue = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++){
            int buyPrice = prices[i];
            for (int j = i + 1; j < n; j++){
                int sellPrice = prices[j];
                int diff = sellPrice - buyPrice;
                if (diff <= 0){
                    continue;
                }
                if (diff > revenue){
                    revenue = diff;
                }
            }
        }
        return revenue;
    }
    public int maxProfit2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit.maxProfit2(new int[]{7,6,4,3,1}));
    }
}
