package com.exercise.algorithm.competition.qgkj;

import java.util.*;

/**
 * @ClassName MaximumSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/17 10:33 PM
 * @Version 1.0
 **/
public class MaximumSum {

    public int getHighBit(int num){
        if (num >= 1 && num <= 9){
            return 1;
        }else if (num >= 10 && num <= 99){
            return 10;
        }else if (num >= 100 && num <= 999){
            return 100;
        }else if (num >= 1000 && num <= 9999){
            return 1000;
        }else if (num >= 10000 && num <= 99999){
            return 10000;
        }else if (num >= 100000 && num <= 999999){
            return 100000;
        }else if (num >= 1000000 && num <= 9999999){
            return 1000000;
        }else if (num >= 10000000 && num <= 99999999){
            return 10000000;
        }else if (num >= 100000000 && num <= 999999999){
            return 100000000;
        }
        return 1000000000;
    }


    public int maximumSum(int[] nums) {
        Map<Integer, ArrayList<Integer>> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int highBit = getHighBit(cur);
            int tempSum = 0;
            int tempCur = cur;
            while (highBit >= 1){
                int curBit = tempCur / highBit;
                tempSum += curBit;
                tempCur = tempCur - highBit * curBit;
                highBit /= 10;
            }
            ArrayList<Integer> numList = sumMap.getOrDefault(tempSum, new ArrayList<>());
            numList.add(cur);
            sumMap.put(tempSum, numList);
        }
        int result = -1;
        for (Map.Entry<Integer, ArrayList<Integer>> map:sumMap.entrySet()){
            List<Integer> numList = map.getValue();
            if (numList.size() < 2){
                continue;
            }
            Collections.sort(numList);
            int sum = numList.get(numList.size() - 1) + numList.get(numList.size() - 2);
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSum maximumSum = new MaximumSum();
        System.out.println(maximumSum.maximumSum(new int[]{18,43,36,13,7}));
        System.out.println(maximumSum.maximumSum(new int[]{10, 12, 19, 14}));
    }
}
