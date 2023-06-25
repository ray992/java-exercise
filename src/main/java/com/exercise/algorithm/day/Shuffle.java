package com.exercise.algorithm.day;

import java.util.Arrays;

// 重新排列数组
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < nums.length; i++){
            if (i < n){
                x[i] = nums[i];
            }else {
                y[i - n] = nums[i];
            }
        }
        int r = 0, q = 0;
        for (int i = 0; i < nums.length; i++){
           if ((i & 1) == 0){
               nums[i] = x[r++];
           }else {
               nums[i] = y[q++];
           }
        }
        return nums;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{1, 1, 2, 2}, 2)));
    }
}
