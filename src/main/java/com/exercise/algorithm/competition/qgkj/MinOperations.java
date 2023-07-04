package com.exercise.algorithm.competition.qgkj;

import java.util.*;

/**
 * @ClassName MinOperations
 * @Description 使数组可以被整除的最少删除次数
 * @Author yeqiang
 * @Date 2022/7/18 8:20 AM
 * @Version 1.0
 **/
public class MinOperations {

    public int minOperations(int[] nums, int[] numsDivide) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num:nums){
            numCountMap.put(num, numCountMap.getOrDefault(num, 0)+1);
        }
        Map<Integer, Integer> numDivideCountMap = new HashMap<>();
        for (int numDive:numsDivide){
            numDivideCountMap.put(numDive, numDivideCountMap.getOrDefault(numDive, 0)+1);
        }
        List<Integer> canDivideList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> numMap:numCountMap.entrySet()){
            int num = numMap.getKey();
            boolean allDivide = true;
            for (Map.Entry<Integer, Integer> divideMap:numDivideCountMap.entrySet()){
                int divide = divideMap.getKey();
                if (divide % num != 0){
                    allDivide = false;
                    break;
                }
            }
            if (allDivide){
                canDivideList.add(num);
            }
        }
        if (canDivideList.size() == 0){
            return  -1;
        }
        Collections.sort(canDivideList);
        int min = canDivideList.get(0);
        Arrays.sort(nums);
        int deleteCount = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= min){
                break;
            }
            deleteCount++;
        }
        return deleteCount;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(new int[]{2,3,2,4,3}, new int[]{9,6,9,3,15}));
        System.out.println(minOperations.minOperations(new int[]{4,3,6}, new int[]{8,2,6,10}));
    }
}
