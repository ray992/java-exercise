package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName RandomNumberIndex
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/25 9:38 AM
 * @Version 1.0
 **/
public class RandomNumberIndex {

    Map<Integer, List<Integer>> numberIndexMap;
    Random random;

    public RandomNumberIndex(int[] nums) {
        numberIndexMap = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++){
            List<Integer> indexList = numberIndexMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            numberIndexMap.put(nums[i], indexList);
        }
    }

    public int pick(int target) {
        List<Integer> indexList = numberIndexMap.get(target);
        return indexList.get(random.nextInt(indexList.size()));
    }

    public static void main(String[] args) {
        RandomNumberIndex randomNumberIndex = new RandomNumberIndex(new int[]{1,2,3,3,3});
        for (int i = 0; i < 10; i++){
            System.out.println(randomNumberIndex.pick(3));
        }
    }
}
