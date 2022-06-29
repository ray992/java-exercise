package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName SortArrayByParity
 * @Description 按奇偶排序数组
 * @Author yeqiang
 * @Date 2022/4/28 9:41 AM
 * @Version 1.0
 **/
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Queue<Integer> oddStack = new ArrayDeque<>();
        Queue<Integer> singleStack = new ArrayDeque<>();
        for (int num:nums){
            if ((num & 1) == 0){
                oddStack.add(num);
            }else {
                singleStack.add(num);
            }
        }
        int i = 0;
        while (!oddStack.isEmpty()){
            res[i] = oddStack.poll();
            i++;
        }
        while (!singleStack.isEmpty()){
            res[i] = singleStack.poll();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
