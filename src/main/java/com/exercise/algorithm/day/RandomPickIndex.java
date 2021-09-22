package com.exercise.algorithm.day;

import java.util.Random;

/**
 * @ClassName RandomPickIndex
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/30 上午9:28
 * @Version 1.0
 **/
public class RandomPickIndex {

    private int sumWeight = 0;

    private Random random = new Random();

    private int[] sum;

    public RandomPickIndex(int[] w){
        sum = new int[w.length];
        int start = 0;
        for (int i = 0; i < w.length; i ++){
            sumWeight+=w[i];
            sum[i] = start + w[i];
            start = w[i];
        }
    }

    public int pickIndex(){
       int index = 0;
       int randomNumber = random.nextInt(sumWeight);
       for (int i = sum.length - 1; i >= 0; i --){
           if (randomNumber >= sum[i]){
               index = i;
               break;
           }
       }
       return index;
    }

    public static void main(String[] args) {
        RandomPickIndex randomPickIndex = new RandomPickIndex(new int[]{1,2,3,4,5,6,7,8,9,10});
        for (int i = 0; i < 100; i++){
            System.out.println(randomPickIndex.pickIndex());
        }
    }
}
