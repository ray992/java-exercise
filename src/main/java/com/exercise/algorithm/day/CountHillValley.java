package com.exercise.algorithm.day;


public class CountHillValley {

    public int countHillValley(int[] nums) {
        int count = 0;
        int len = nums.length;
        boolean[][] hasMatch = new boolean[len][len];
        for (int i = 0; i < len; i++){
            if (i == 0 || i == len -1 ){
                continue;
            }
            int cur = nums[i];
            int left = 0;
            int right = 0;
            int leftIndex = -1;
            int rightIndex = -1;
            for (int j = i-1; j >= 0; j--){
                if (cur != nums[j]){
                    left = nums[j];
                    leftIndex = j;
                    break;
                }
            }
            for (int k = i+1; k < len; k++){
                if (cur != nums[k]){
                    right = nums[k];
                    rightIndex = k;
                    break;
                }
            }
            if (left == 0 || right == 0 || hasMatch[leftIndex][rightIndex]){
                continue;
            }
            if ((cur > left && cur > right) || (cur < left && cur < right)){
                hasMatch[leftIndex][rightIndex] = true;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountHillValley countHillValley = new CountHillValley();
        System.out.println(countHillValley.countHillValley(new int[]{2,4,1,1,6,5}));
        System.out.println(countHillValley.countHillValley(new int[]{6,6,5,5,4,1}));
    }
}
