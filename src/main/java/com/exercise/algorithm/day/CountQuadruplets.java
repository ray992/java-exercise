package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CountQuadruplets
 * @Description 统计特殊四元祖
 * @Author yeqiang
 * @Date 2021/12/29 下午1:22
 * @Version 1.0
 **/
public class CountQuadruplets {

    public int countQuadruplets(int[] nums) {
        //Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    for (int m = k+1; m < n; m++){
                        if ((nums[i] + nums[j] + nums[k] == nums[m]) && (i < j) && (j < k) && (k < m)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountQuadruplets countQuadruplets = new CountQuadruplets();
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1,2,3,6}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{3,3,6,4,5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{1,1,1,3,5}));
        System.out.println(countQuadruplets.countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
    }
}
