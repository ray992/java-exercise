package com.exercise.algorithm.day;

/**
 * @ClassName PivotIndex
 * @Description 寻找数组的中心下标
 * @Author yeqiang
 * @Date 2022/7/4 8:38 AM
 * @Version 1.0
 **/
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; i++){
            left += (i -1) >= 0? nums[i - 1]:0;
            right -= nums[i];
            if (left == right){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[]{2, 1, -1}));
    }
}
