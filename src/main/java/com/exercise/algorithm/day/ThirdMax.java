package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ThirdMax
 * @Description 返回第三大的数
 * @Author yeqiang
 * @Date 2021/10/6 上午11:03
 * @Version 1.0
 **/
public class ThirdMax {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Set<Integer> duplicateNumberSet = new HashSet<>();
        for (int n:nums){
            if (!duplicateNumberSet.add(n)){
                continue;
            }
            priorityQueue.add(n);
        }
        int size = priorityQueue.size();
        int ans = 0;
        if (size >= 3) {
            priorityQueue.poll();
            priorityQueue.poll();
        }
        ans = !priorityQueue.isEmpty() ? priorityQueue.poll():ans;
        return ans;
    }

    public int thirdMax2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n < 3){
            return nums[n-1];
        }
        Set<Integer> duplicateSet = new HashSet<>();
        int ans = nums[n-1];
        int validIndex = 0;
        for (int i = (n -1); i >=0; i--){
            int tempNum = nums[i];
            if (duplicateSet.add(tempNum)){
                validIndex++;
            }
            if (validIndex == 3){
                ans = tempNum;
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        System.out.println(thirdMax.thirdMax2(new int[]{3, 2, 1}));
        System.out.println(thirdMax.thirdMax2(new int[]{1, 2}));
        System.out.println(thirdMax.thirdMax2(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax.thirdMax2(new int[]{-2147483648,1,1}));
    }
}
