package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {

    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> countNumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != key || i+1 > nums.length -1){
                continue;
            }
            countNumMap.put(nums[i+1], countNumMap.getOrDefault(nums[i+1], 1)+1);
        }
        int maxTime = -1;
        int res = 0;
        for (Map.Entry<Integer, Integer> map:countNumMap.entrySet()){
            Integer target = map.getKey();
            Integer times = map.getValue();
            if (maxTime < times){
                maxTime = times;
                res = target;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MostFrequent mostFrequent = new MostFrequent();
        //System.out.println(mostFrequent.mostFrequent(new int[]{2,2,2,2,3}, 2));
        //System.out.println(mostFrequent.mostFrequent(new int[]{1,100,200,1,100}, 1));
        System.out.println(mostFrequent.mostFrequent(new int[]{2,1000,2,1000,2,3}, 2));
    }
}
