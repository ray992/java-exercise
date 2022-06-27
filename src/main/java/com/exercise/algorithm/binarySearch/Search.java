package com.exercise.algorithm.binarySearch;

public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int middle = (right - left) /2 + left;
            if (nums[middle] < target){
                left = middle + 1;
            }else if (nums[middle] > target){
                right = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 12));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 4));
        System.out.println(search.search(new int[]{-1,0,3,5,6,9,12}, 6));
        System.out.println(search.search(new int[]{-1,0,3,5,6,9,12}, -1));
    }
}
