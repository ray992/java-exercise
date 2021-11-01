package com.exercise.algorithm.day;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName DistributeCandies
 * @Description 分糖果
 * @Author yeqiang
 * @Date 2021/11/1 上午9:36
 * @Version 1.0
 **/
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int averageCount = n / 2;
        Map<Integer, Integer> candyMap = new HashMap<>();
        for (int c:candyType){
            candyMap.put(c, candyMap.getOrDefault(c, 0)+1);
        }
        Set<Integer> candyTypeSet = candyMap.keySet();
        return Math.min(candyTypeSet.size(), averageCount);
    }

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        System.out.println(distributeCandies.distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(distributeCandies.distributeCandies(new int[]{1,1,2,3,2,3}));
    }

}
