package com.exercise.algorithm.day;

import java.util.Arrays;

public class TrimMean {

    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int delSize = n * 5 / 100;
        long sum = 0l;
        for (int i = 0; i < n; i++){
            sum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < delSize; i++){
            leftSum += arr[i];
        }
        int rightSum = 0;
        for (int i = n - 1; i > n - delSize - 1; i--){
            rightSum += arr[i];
        }
        return (double) (sum - leftSum - rightSum) / (n - delSize - delSize);
    }

    public static void main(String[] args) {
        TrimMean trimMean = new TrimMean();
        System.out.println(trimMean.trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
        System.out.println(trimMean.trimMean(new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}));
        System.out.println(trimMean.trimMean(new int[]{9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3}));
    }
}
