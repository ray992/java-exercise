package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MajorityElement
 * @Description 求众数
 * @Author yeqiang
 * @Date 2021/10/22 上午12:03
 * @Version 1.0
 **/
public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        int n = nums.length;
        int times = n / 3;
        Arrays.sort(nums);
        int count = 0;
        int pre = Integer.MAX_VALUE;
        for (int element:nums){
            if (pre != element){
                if (pre != Integer.MAX_VALUE && count > times){
                    resList.add(pre);
                }
                pre = element;
                count = 1;
            }else {
                count++;
            }
        }
        if (count > times){
            resList.add(pre);
        }
        return resList;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement.majorityElement(new int[]{1}));
        System.out.println(majorityElement.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
