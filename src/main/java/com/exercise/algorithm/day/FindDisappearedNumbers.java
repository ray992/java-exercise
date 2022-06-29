package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindDisappearedNumbers
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/29 11:44 PM
 * @Version 1.0
 **/
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> existNumberSet = new HashSet<>();
        for (int i = 0; i < nums.length;i++){
            existNumberSet.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++){
            if (!existNumberSet.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{1,1}));
    }
}
