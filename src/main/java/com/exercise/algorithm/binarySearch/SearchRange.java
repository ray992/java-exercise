package com.exercise.algorithm.binarySearch;

import java.util.Arrays;

/**
 * @ClassName SearchRange
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Author yeqiang
 * @Date 2022/7/2 10:00 AM
 * @Version 1.0
 **/
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int temp = -1;
        while (left <= right){
            int middle = (right - left) / 2 + left;
            if (nums[middle] == target){
                temp = middle;
                break;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                right = middle -1;
            }
        }
        if (temp == -1){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        for (int i = temp; i >= 0; i--){
            if (nums[i] != target){
                break;
            }
            res[0] = i;
        }
        for (int j = temp; j < n; j++){
            if (nums[j] != target){
                break;
            }
            res[1] = j;
        }
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int start = binarySearch(nums, target);
        int end = binarySearch(nums, target + 1);
        if (start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        return new int[]{start, end - 1};
    }

    public int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = (right - left) / 2 + left;
            if (nums[middle] >= target){
                right = middle;
            }else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
       // System.out.println(Arrays.toString(searchRange.searchRange2(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange.searchRange2(new int[]{2}, 2)));
    }
}

