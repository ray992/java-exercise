package com.exercise.algorithm.day;

/**
 * @ClassName NumWaterBottles
 * @Description 换酒问题
 * @Author yeqiang
 * @Date 2021/12/17 上午9:46
 * @Version 1.0
 **/
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange){
            return numBottles;
        }
        int sum = numBottles;
        int changeCount = numBottles;
        int mod = 0;
        while ((changeCount+mod) >= numExchange){
            changeCount = numBottles/numExchange;
            mod = numBottles % numExchange;
            sum = sum + changeCount;
            numBottles = changeCount + mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        System.out.println(numWaterBottles.numWaterBottles(9, 3));
        System.out.println(numWaterBottles.numWaterBottles(15, 4));
    }
}
