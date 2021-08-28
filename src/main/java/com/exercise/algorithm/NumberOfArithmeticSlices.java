package com.exercise.algorithm;

import java.util.*;

/**
 * @ClassName NumberOfArithmeticSlices
 * @Description 等差数列划分
 * @Author yeqiang
 * @Date 2021/8/10 上午9:02
 * @Version 1.0
 **/
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int ret = 0;
        int length = nums.length;
        int childLength = 3;
        Set<Integer> diffSet = new HashSet<>();
        while (childLength <= length){
            int start = 0;
            int i = start;
            boolean sameDiff = true;
            int l = 0;
            while (i  <= nums.length - 1 && (childLength + i) <= nums.length && l <= childLength ){
                l++;
                int diff = nums[i] - nums[i+1];
                if (diffSet.size() > 0 && !diffSet.contains(diff)){
                    sameDiff = false;
                    break;
                }
                diffSet.add(diff);
                i++;
                if (i == nums.length - 1){
                    childLength++;
                    break;
                }
            }
            if (sameDiff){
                ret++;
                diffSet.clear();
            }
        }
        return ret;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int ret = 0;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++){
            diff[i] = nums[i] - nums[i+1];
        }
        int startChildArrayLength = 2;
        Set<Integer> diffSet = new HashSet<>();
        while (startChildArrayLength <= diff.length){
            int i = 0;
            int j = i;
            int count = 0;
            while (count <= startChildArrayLength && j <= diff.length - 1){
                diffSet.add(diff[j]);
                count++;
                j++;
                if (count == startChildArrayLength){
                    if (diffSet.size() == 1){
                        ret++;
                    }
                    i++;
                    j = i;
                    count = 0;
                    diffSet.clear();
                }
            }
            startChildArrayLength++;
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices numberOfArithmeticSlices = new NumberOfArithmeticSlices();
        //System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices2(new int[]{1,2,3,4}));
        //System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices2(new int[]{1}));
        System.out.println(numberOfArithmeticSlices.numberOfArithmeticSlices2(new int[]{1,2,3,8,9,10}));
    }
}
