package com.exercise.algorithm;

/**
 * @ClassName FinalPrices
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/1 上午10:32
 * @Version 1.0
 **/
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i ++){
            int currentPrice = prices[i];
            int discount = 0;
            for (int j = i+1; j < prices.length; j++){
                if (prices[j] < currentPrice){
                    discount = prices[j];
                    break;
                }
            }
            result[i] = currentPrice - discount;
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] prices = {8,4,6,2,3};
        int[] prices = {1,2,3,4,5};
        FinalPrices finalPrices = new FinalPrices();
        int[] result = finalPrices.finalPrices(prices);
        for (int price:result){
            System.out.println(price);
        }
    }
}
