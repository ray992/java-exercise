package com.exercise.algorithm.day;

/**
 * @ClassName Search
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/6 上午9:12
 * @Version 1.0
 **/
public class Search {


    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        if (nums[start] > target || nums[end] < target){
            return -1;
        }
        while (true){
            if (start > end){
                return -1;
            }
            int midIndex = (end - start)/2 + start;
            if (nums[midIndex] > target){
                end = midIndex - 1;
            }else if (nums[midIndex] < target){
                start = midIndex + 1;
            }else {
                return midIndex;
            }
        }
    }

    public static void main(String[] args) {
        Search search = new Search();
        //System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 2));
        //System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 9));
        //System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 4));
        //System.out.println(search.search(new int[]{-1,0,3,5,9,12}, -1));
        //System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 0));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 3));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 5));
        System.out.println(search.search(new int[]{-1,0,3,5,9,12}, 11));
    }
}
