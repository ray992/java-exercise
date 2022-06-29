package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName FindClosestNumber
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 10:30 PM
 * @Version 1.0
 **/
public class FindClosestNumber {

    public int findClosestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i <nums.length; i++){
            numList.add(nums[i]);
        }
        if (numList.contains(0)){
            return 0;
        }
        numList.add(0);
        Collections.sort(numList);
        int pre = numList.get(0);
        if (pre == 0){
            return numList.get(1);
        }
        for (int i = 1; i < numList.size(); i++){
            if (numList.get(i) == 0){
                if (i == numList.size() - 1){
                    return pre;
                }else {
                    int next = numList.get(i+1);
                    int l1 = Math.abs(pre);
                    int l2 = Math.abs(next);
                    if (l1 < l2){
                        return pre;
                    }else {
                        return next;
                    }
                }
            }else {
                pre = numList.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindClosestNumber findClosestNumber = new FindClosestNumber();
        System.out.println(findClosestNumber.findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber.findClosestNumber(new int[]{2, -1, 1}));
    }
}
