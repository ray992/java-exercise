package com.exercise.algorithm.day;

import java.util.*;

public class MinimalKSum {

    public long minimalKSum(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        int i = 0;
        int start = 1;
        long sum = 0;
        while (i < k){
            if (numsList.contains(start)){
                start++;
                continue;
            }
            numsList.add(start);
            sum = sum + start;
            start++;
            i++;
        }
        return sum;
    }

    public long minimalKSum2(int[] nums, int k) {
        List<int[]> countList = new ArrayList<>();
        int st = 1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int min = nums[0];
        if (min  > st){
            int[] a = new int[2];
            a[0] = 1;
            a[1] = min -1;
            countList.add(a);
        }
        Set<Integer> compareSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if (!compareSet.add(cur)){
                continue;
            }
            int[] a = new int[2];
            if (i+1 < nums.length){
                if (cur >= nums[i+1] - 1){
                    continue;
                }
                a[0] = cur+1;
                a[1] = nums[i+1] -1;
                countList.add(a);
            }else {
                a[0] = cur + 1;
                a[1] = Integer.MAX_VALUE;
                countList.add(a);
            }
        }
        int consumeCount = 0;
        long res = 0;
        for (int[] aa:countList){
            int s = aa[0];
            int e = aa[1];
            if (e - s + 1 + consumeCount > k){
                int ae = k - consumeCount;
                int sum = ((s + s + ae - 1) * ae)>>1;
                res = res + sum;
                break;
            }else {
                int sum = ((s + e)*(e -s + 1))>>1;
                res = res + sum;
                consumeCount = consumeCount + (e -s + 1);
                System.out.println(s + " "+ e + " "+ sum + " "+ consumeCount);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimalKSum minimalKSum = new MinimalKSum();
        System.out.println(minimalKSum.minimalKSum2(new int[]{1,4,25,10,25}, 2));
        System.out.println(minimalKSum.minimalKSum2(new int[]{5, 6}, 6));
        System.out.println(minimalKSum.minimalKSum2(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84}, 35));
    }
}
