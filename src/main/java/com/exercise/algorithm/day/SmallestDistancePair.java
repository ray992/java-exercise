package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> distanceList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                distanceList.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(distanceList);
        return distanceList.get(k -1);
    }

    public int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left <= right){
            int middle = (left + right) / 2;
            int cnt = 0;
            for (int j = 0, i = 0; j < n; j++){
                while (nums[j] - nums[i] > middle){
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        System.out.println(smallestDistancePair.smallestDistancePair(new int[]{1,3,1}, 1));
        System.out.println(smallestDistancePair.smallestDistancePair(new int[]{1,1,1}, 2));
        System.out.println(smallestDistancePair.smallestDistancePair2(new int[]{1,6,1}, 3));
    }
}
