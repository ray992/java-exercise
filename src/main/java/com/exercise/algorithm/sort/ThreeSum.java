package com.exercise.algorithm.sort;

import java.lang.management.LockInfo;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName ThreeSum
 * @Description 三数之和：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * @Author yeqiang
 * @Date 2021/8/10 下午10:09
 * @Version 1.0
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> duplicateSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                for (int k = j+1; k < nums.length; k++){
                    if (i == j || i == k || j == k){
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0){
                        String match = nums[i] +""+nums[j]+""+nums[k];
                        if (duplicateSet.contains(match)){
                            continue;
                        }else {
                            duplicateSet.add(match);
                        }
                        List<Integer> childList = new ArrayList<>();
                        childList.add(nums[i]);
                        childList.add(nums[j]);
                        childList.add(nums[k]);
                        answerList.add(childList);
                    }
                }
            }
        }
        return answerList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> duplicateMap = new HashMap<>();
        for (int k = 0; k < nums.length; k++){
            if (duplicateMap.containsKey(nums[k])){
                duplicateMap.get(nums[k]).add(k);
            }else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(k);
                duplicateMap.put(nums[k], indexList);
            }
        }
        Set<String> duplicateSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                int halfSum = nums[i] + nums[j];
                int diff = -halfSum;
                if (duplicateMap.containsKey(diff)){
                    List<Integer> indexList = duplicateMap.get(diff);
                    if ((!indexList.contains(i) && !indexList.contains(j)) || indexList.size() > 2){
                        int[] temp = new int[]{nums[i],nums[j],diff};
                        Arrays.sort(temp);
                        String match = temp[0] +""+temp[1]+""+temp[2];
                        if (duplicateSet.contains(match)){
                            continue;
                        }else {
                            duplicateSet.add(match);
                        }
                        List<Integer> childList = new ArrayList<>();
                        childList.add(nums[i]);
                        childList.add(nums[j]);
                        childList.add(diff);
                        answerList.add(childList);
                    }
                }
            }
        }
        return answerList;
    }

    //双指针法

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum2(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum.threeSum2(new int[]{}));
        System.out.println(threeSum.threeSum2(new int[]{0}));
        System.out.println(threeSum.threeSum2(new int[]{0,0,0}));
        for (int i = 0; i < 10; ++i){
            System.out.println(i);
        }
    }
}
