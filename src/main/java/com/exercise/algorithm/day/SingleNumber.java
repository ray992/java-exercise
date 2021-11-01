package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName SingleNumber
 * @Description 只出现一次的数
 * @Author yeqiang
 * @Date 2021/10/30 下午5:00
 * @Version 1.0
 **/
public class SingleNumber {

    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int happenSingleCount = 0;
        Arrays.sort(nums);
        int[] res = new int[2];
        int cur = 0;
        for (int i = 0; i < n; i++){
            if ((i < (n -1) && (cur !=  nums[i] && nums[i] != nums[i + 1])) ||i == (n-1) && cur !=  nums[i]){
               res[happenSingleCount] = nums[i];
               happenSingleCount++;
            }
            if (happenSingleCount == 2){
                break;
            }
            cur = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(Arrays.toString(singleNumber.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(singleNumber.singleNumber(new int[]{-1,0})));
        System.out.println(Arrays.toString(singleNumber.singleNumber(new int[]{0,1})));
    }
}
