package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ThreeSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/2 6:16 PM
 * @Version 1.0
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n <= 2){
            return res;
        }
        Map<Integer, List<Integer>> elePosMap = new HashMap<>();
        for (int i = 0 ; i < n; i++){
            List<Integer> indexList = elePosMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            elePosMap.put(nums[i], indexList);
        }
        Set<String> duplicateSet = new HashSet<>();
        List<Integer[]> resTemp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                Integer[] temp = new Integer[3];
                temp[0] = nums[i];
                temp[1] = nums[j];
                resTemp.add(temp);
            }
        }
        for (Integer[] temp:resTemp){
            int diff = -temp[0] - temp[1];
            if (!elePosMap.containsKey(diff)){
                continue;
            }
            List<Integer> indexList = elePosMap.get(diff);
            int count = 1;
            if (temp[0] == diff){
                count++;
            }
            if (temp[1] == diff){
                count++;
            }
            if (indexList.size() >= count){
                temp[2] = diff;
                Arrays.sort(temp);
                if (!duplicateSet.add(temp[0] + "_" + temp[1]+ "_"+temp[2])){
                    continue;
                }
                res.add(Arrays.asList(temp));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
