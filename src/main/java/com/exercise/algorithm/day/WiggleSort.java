package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 摆动排序
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
       int n = nums.length;
       Arrays.sort(nums);
       int[] copyArray = Arrays.copyOf(nums, n);
       int left = 0;
       int right = n /2;
       for (int i = 0; i < n; i++){
           nums[i] = (i % 2 ) == 0 ? copyArray[left++]:copyArray[right++];
       }
       System.out.println(Arrays.toString(nums));
    }

    /**
     * 关键从后往前移动
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1,left = right/2;
        int[] temp = Arrays.copyOf(nums,nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[i] = i % 2 == 0 ? temp[left--] :  temp[right--];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(new int[]{1,5,1,1,6,4});
        wiggleSort.wiggleSort(new int[]{1,3,2,2,3,1});
        wiggleSort.wiggleSort(new int[]{1});
        wiggleSort.wiggleSort(new int[]{1,2,3});
        wiggleSort.wiggleSort(new int[]{4,5,5,6});
    }

}
