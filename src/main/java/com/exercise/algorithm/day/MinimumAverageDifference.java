package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName MinimumAverageDifference
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/30 下午11:09
 * @Version 1.0
 **/
public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        Map<Integer, long[]> indexSumMap = new HashMap<>();
        long sum = 0;
        for (int num:nums){
            sum+=num;
        }
        int pre = 0;
        for (int i = 0; i < nums.length; i++){
            pre = pre + nums[i];
            indexSumMap.put(i, new long[]{pre,  (sum - pre)});
        }
        Map<Long, List<Integer>> indexMap = new HashMap<>();
        long res = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            long[] indexSum =  indexSumMap.get(i);
            long s1 = indexSum[0];
            long s2 = indexSum[1];
            long diff = 0;
            if (i < nums.length - 1){
                diff = Math.abs(s1 / (i+1) - s2 / (nums.length - i - 1));
            }else {
                diff = Math.abs(s1 / (i+1));
            }
            List<Integer> indexList =  indexMap.getOrDefault(diff, new ArrayList<>());
            indexList.add(i);
            indexMap.put(diff, indexList);
            if (diff < res){
                res = diff;
            }
        }
        List<Integer> indexList = indexMap.get(res);
        Collections.sort(indexList);
        return indexList.get(0);
    }

    public static void main(String[] args) {

    }
}
