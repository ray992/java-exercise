package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/29 11:21 PM
 * @Version 1.0
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            List<Integer> indexList = posMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            posMap.put(nums[i], indexList);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int ano = target - cur;
            List<Integer> indexList = posMap.get(ano);
            if (indexList == null || indexList.size() < 1){
                continue;
            }
            for (int t = 0; t < indexList.size(); t++){
                if (indexList.get(t) == i){
                    continue;
                }
                res[0] = i+1;
                res[1] = indexList.get(t)+1;
            }
        }
        Arrays.sort(res);
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if (sum == target){
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }else if (sum > target){
                r--;
            }else {
                l++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{2,7, 11,15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum2(new int[]{-1, 0}, -1)));
    }
}
