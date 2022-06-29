package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName Intersection
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/24 10:33 AM
 * @Version 1.0
 **/
public class Intersection {

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> happensMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                happensMap.put(nums[i][j], happensMap.getOrDefault(nums[i][j], 0)+1);
            }
        }
        int n = nums.length;
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> map:happensMap.entrySet()){
            Integer key = map.getKey();
            Integer times = map.getValue();
            if (times == n){
                resList.add(key);
            }
        }
        Collections.sort(resList);
        return resList;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        System.out.println(intersection.intersection(new int[][]{{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6} }));
        System.out.println(intersection.intersection(new int[][]{ {1,2,3}, {4,5,6} }));
    }
}
