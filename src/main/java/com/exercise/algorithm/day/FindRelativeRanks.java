package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindRelativeRanks
 * @Description 相对名次
 * @Author yeqiang
 * @Date 2021/12/2 上午9:40
 * @Version 1.0
 **/
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int[] copyScore = new int[score.length];
        System.arraycopy(score, 0, copyScore, 0, score.length);
        Arrays.sort(score);
        Map<Integer, Integer> positionMap = new HashMap<>();
        int position = 1;
        for (int i = score.length - 1; i >=0; i--){
            positionMap.put(score[i], position);
            position++;
        }
        String[] res = new String[score.length];
        for (int i = 0; i < copyScore.length; i++){
            int order = positionMap.get(copyScore[i]);
            if (order == 1){
                res[i] = "Gold Medal";
            }else if (order == 2){
                res[i] = "Silver Medal";
            }else if (order == 3){
                res[i] = "Bronze Medal";
            }else {
                res[i] = String.valueOf(order);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        System.out.println(Arrays.toString(findRelativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(findRelativeRanks.findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
