package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName Solution
 * @Description 随机打乱数组
 * @Author yeqiang
 * @Date 2021/11/22 下午2:12
 * @Version 1.0
 **/
public class Solution {

    int[] cache = null;

    public Solution(int[] nums) {
        cache = nums;
    }

    public int[] reset() {
        return cache;
    }

    public int[] shuffle() {
        int[] copyArray = new int[cache.length];
        System.arraycopy(cache, 0, copyArray, 0, copyArray.length);
        List<Integer> dataList = new ArrayList<>();
        for (int n:copyArray){
            dataList.add(n);
        }
        int[] shuffleArray = new int[copyArray.length];
        Random random = new Random();
        for (int i = 0; i < copyArray.length; i++){
            int j = random.nextInt(dataList.size());
            shuffleArray[i] = dataList.remove(j);
        }
        return shuffleArray;
    }
}
