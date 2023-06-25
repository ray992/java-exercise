package com.exercise.algorithm.day;

public class MinStartValue {

    public int minStartValue(int[] nums) {
        int minSum = 1;
        int addSum = 0;
        for (int num:nums){
            addSum = addSum + num;
            minSum = Math.min(minSum, addSum);
        }
        return minSum > 0 ? 1: (1 - minSum);
    }

    public static void main(String[] args) {
        MinStartValue minStartValue = new MinStartValue();
        System.out.println(minStartValue.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(minStartValue.minStartValue(new int[]{1, 2}));
        System.out.println(minStartValue.minStartValue(new int[]{1, -2, -3}));
    }
}
