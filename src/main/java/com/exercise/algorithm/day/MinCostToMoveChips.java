package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MinCostToMoveChips
 * @Description 玩筹码
 * @Author yeqiang
 * @Date 2022/7/8 8:18 AM
 * @Version 1.0
 **/
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        Map<Integer, Integer>  chipMap = new HashMap<>();
        for (int pos:position){
            chipMap.put(pos, chipMap.getOrDefault(pos, 0) + 1);
        }
        int pos = 0;
        int count = -1;
        for (Map.Entry<Integer, Integer> map:chipMap.entrySet()){
            int key = map.getKey();
            int value = map.getValue();
            if (value >= count){
                pos = key;
                count = value;
            }
        }
        int cost = 0;
        for (Map.Entry<Integer, Integer> map:chipMap.entrySet()){
            int key = map.getKey();
            int value = map.getValue();
            int diff = Math.abs(key - pos);
            if ((diff & 1) == 1){
                cost += value;
            }
        }
        return cost;
    }

    public int minCostToMoveChips2(int[] position) {
        int odd = 0;
        int even =0;
        for (int i = 0; i < position.length; i++){
            if ((position[i] & 1) == 0){
                even++;
            }else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();
        //System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{1,2,3}));
        //System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{1,100000}));
        //System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{2,2,2,3,3}));
        //System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{2,3,3}));
        //System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{3,3,1,2,2,4,4,5,5}));
        System.out.println(minCostToMoveChips.minCostToMoveChips2(new int[]{6,4,7,8,2,10,2,7,9,7}));
    }
}
