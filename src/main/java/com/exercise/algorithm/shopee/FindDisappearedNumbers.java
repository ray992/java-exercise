package com.exercise.algorithm.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int n = nums.length;
        int[] origin = new int[n];
        Arrays.fill(origin, 0);
        for (int i = 0; i < n; i++){
            int cur = origin[nums[i] - 1];
            if (cur == 0){
                origin[nums[i] - 1] = nums[i];
            }
        }
        for (int t = 0; t < n; t++){
            if (origin[t] == 0){
                resultList.add(t+1);
            }
        }
        return resultList;
    }


    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        //System.out.println(findDisappearedNumbers.findDisappearedNumbers2(new int[]{1,1}));
    }
}
