package com.exercise.algorithm.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (numberMap.containsKey(target - nums[i])){ //注意这里处理了相同的key的问题， 先出现的会被插到map里，这里容易被忽略
                return new int[]{numberMap.get(target - nums[i]), i};
            }
            numberMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum_1 twoSum1 = new TwoSum_1();
        System.out.println(Arrays.toString(twoSum1.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
