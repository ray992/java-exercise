package com.exercise.algorithm.competition.qgkj;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumberOfPairs
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/17 10:26 PM
 * @Version 1.0
 **/
public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer>  numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0)+1);
        }
        int match = 0;
        int noMatch = 0;
        for (Map.Entry<Integer, Integer> map:numMap.entrySet()){
            int count = map.getValue();
            match += count / 2;
            noMatch += count % 2;
        }
        return new int[]{match, noMatch};
    }

    public static void main(String[] args) {

    }
}
