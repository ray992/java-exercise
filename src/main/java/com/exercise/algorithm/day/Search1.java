package com.exercise.algorithm.day;

/**
 * @ClassName Search1
 * @Description 二分查找
 * @Author yeqiang
 * @Date 2022/7/6 10:13 AM
 * @Version 1.0
 **/
public class Search1 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l:-1;
    }

    public static void main(String[] args) {
        Search1 search1 = new Search1();
        System.out.println(search1.search(new int[]{1,2, 3}, 1));
    }
}
