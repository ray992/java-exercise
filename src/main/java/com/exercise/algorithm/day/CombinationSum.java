package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CombinationSum
 * @Description 组合总和
 * @Author yeqiang
 * @Date 2022/7/12 10:09 AM
 * @Version 1.0
 **/
public class CombinationSum {

    public List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(0, target, candidates, new ArrayList<>());
        return resultList;
    }

    public void backTracking(int curSum, int target, int[] candidates, List<Integer> combinationList){
        //结束条件
        if (curSum == target){
            resultList.add(new ArrayList<>(combinationList));
            return;
        }
        for (int candidate:candidates){
            if (curSum + candidate > target){
                break;
            }
            combinationList.add(candidate);
            curSum += candidate;
            backTracking(curSum, target, candidates, combinationList);
            curSum -= candidate;
            combinationList.remove(combinationList.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));
    }

}
