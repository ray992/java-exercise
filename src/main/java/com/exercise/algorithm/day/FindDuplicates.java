package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindDuplicates
 * @Description 数组中重复的数据
 * @Author yeqiang
 * @Date 2022/5/8 10:09 AM
 * @Version 1.0
 **/
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 1){
            return res;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == pre){
                res.add(nums[i]);
            }
            pre = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println(findDuplicates.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicates.findDuplicates(new int[]{1,1,2}));
        System.out.println(findDuplicates.findDuplicates(new int[]{1}));
    }
}
