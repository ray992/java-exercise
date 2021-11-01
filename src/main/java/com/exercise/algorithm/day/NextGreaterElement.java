package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName NextGreaterElement
 * @Description 下一个更大元素
 * @Author yeqiang
 * @Date 2021/10/26 上午9:03
 * @Version 1.0
 **/
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> nextNumberMap = new LinkedHashMap<>();
        for (int i = 0; i < nums2.length; i++){
            int curl = nums2[i];
            boolean hitStatus = false;
            for (int j = i + 1; j < nums2.length; j++){
                if (nums2[j] > curl){
                    hitStatus = true;
                    nextNumberMap.put(curl, nums2[j]);
                    break;
                }
            }
            if (!hitStatus){
                nextNumberMap.put(curl, -1);
            }
        }
        int i = 0;
        for (int cur:nums1){
            res[i] = nextNumberMap.get(cur);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[]{2, 4}, new int[]{1,2,3,4})));
    }
}
