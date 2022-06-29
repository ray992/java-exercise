package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MinimumCardPickup
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/1 10:40 AM
 * @Version 1.0
 **/
public class MinimumCardPickup {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> sameCardIndexMap = new HashMap<>();
        for (int i = 0; i < cards.length; i++){
            List<Integer> indexList = sameCardIndexMap.getOrDefault(cards[i], new ArrayList<>());
            indexList.add(i);
            sameCardIndexMap.put(cards[i], indexList);
        }
        int minCount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> map:sameCardIndexMap.entrySet()){
            List<Integer> indexList = map.getValue();
            for (int i = 0; i < indexList.size() - 1; i++){
                int diff = indexList.get(i+1) - indexList.get(i);
                if (diff < minCount){
                    minCount = diff;
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1: minCount + 1;
    }

    public static void main(String[] args) {
        MinimumCardPickup minimumCardPickup = new MinimumCardPickup();
        System.out.println(minimumCardPickup.minimumCardPickup(new int[]{3,4,2,3,4,7}));
        System.out.println(minimumCardPickup.minimumCardPickup(new int[]{1,0,5,3}));
        System.out.println(minimumCardPickup.minimumCardPickup(new int[]{0,0,5,3}));
    }
}
