package com.exercise.algorithm.offer;


import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int n = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (numSet.contains(nums[i])){
                n = nums[i];
                break;
            }else {
                numSet.add(nums[i]);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber.findRepeatNumber(new int[]{1,1,1}));
        System.out.println(findRepeatNumber.findRepeatNumber(new int[]{3,1,2,3}));
    }
}
