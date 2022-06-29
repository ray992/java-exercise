package com.exercise.algorithm.day;

/**
 * @ClassName SearchInsert
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/22 10:52 PM
 * @Version 1.0
 **/
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        int cur = nums[left];
        return target > cur?left+1:left;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert.searchInsert(new int[]{2,3,5,6}, 1));
    }
}
