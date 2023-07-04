package com.exercise.algorithm.competition.zgzl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName FillCups
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/10 10:30 AM
 * @Version 1.0
 **/
public class FillCups {

    public int fillCups(int[] amount) {
        int time = 0;
        int sum = 0;
        for (int a:amount){
            sum += a;
        }
        while (sum > 0){
            int n = 0;
            Arrays.sort(amount);
            for (int i = 2; i >=0; i--){
                if (amount[i] > 0){
                    amount[i]--;
                    sum--;
                    n++;
                }
                if (n == 2){
                    break;
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        FillCups fillCups = new FillCups();
        System.out.println(fillCups.fillCups(new int[]{5,0,0}));
    }
}
