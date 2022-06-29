package com.exercise.algorithm.day;

/**
 * @ClassName NumSubarrayProductLessThanK
 * @Description 乘积小于K的子树组
 * @Author yeqiang
 * @Date 2022/5/5 9:19 AM
 * @Version 1.0
 **/
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (k == 0){
            return 0;
        }
        int count = 0;
        int product = 1;
        for (int l = 0, r = 0 ; r < n; r++){
            int cur = nums[r];
            product*=cur;
            while (product >= k && l <= r){
                product /= nums[l++];
            }
            count+= r - l + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
