package com.exercise.algorithm.day;

import java.util.Arrays;

public class FindPairs {

    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        if (n == 1){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int sum = 0;
        int pre = -1;
        while (right < n){
            int cnt = 0;
            if (pre == nums[left]){
                left++;
                right = left + 1;
                continue;
            }
            while (nums[right] - nums[left] <= k){
                if (nums[right] - nums[left] == k){
                    cnt++;
                }
                right++;
                if (right > n-1){
                    break;
                }
            }
            sum += cnt;
            left++;
            right = left + 1;
            pre = nums[left];
        }
        return sum;
    }

    public static void main(String[] args) {
        FindPairs findPairs = new FindPairs();
        System.out.println(findPairs.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs.findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(findPairs.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(findPairs.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
    }
}
