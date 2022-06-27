package com.exercise.algorithm.day;

import java.util.Arrays;

public class HeightChecker {


    public int heightChecker(int[] heights) {
        int[] cloneHeights =  Arrays.copyOf(heights, heights.length);
       Arrays.sort(cloneHeights);
       int count = 0;
       for (int i = 0; i < heights.length; i++){
           if (heights[i] != cloneHeights[i]){
               count++;
           }
       }
       return count;
    }

    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(new int[]{1,1,4,2,1,3}));
        System.out.println(heightChecker.heightChecker(new int[]{5,1,2,3,4}));
    }
}
