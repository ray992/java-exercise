package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName MinMoves
 * @Description 最小操作次数使数组元素相等
 * @Author yeqiang
 * @Date 2021/10/20 上午10:02
 * @Version 1.0
 **/
public class MinMoves {

    public int minMoves(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[n - 1]){
            for (int i = 0; i < n - 1; i++){
                nums[i] = nums[i] + 1;
            }
            count++;
            Arrays.sort(nums);
        }
        return count;
    }

    public int minMoves2(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num:nums){
            res += num - min;
        }
        return res;
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        System.out.println(minMoves.minMoves2(new int[]{1,2,3}));
        System.out.println(minMoves.minMoves2(new int[]{1,1,1}));
        System.out.println(minMoves.minMoves2(new int[]{1,1000000000}));
    }
}
