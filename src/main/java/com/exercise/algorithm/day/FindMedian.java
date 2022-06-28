package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName FindMedian
 * @Description 寻找两个有序数组的中位数
 * @Author yeqiang
 * @Date 2020/12/7 10:27 下午
 * @Version 1.0
 **/
public class FindMedian {

    public static void main(String[] args) {
        int[] nums1 = {1,2,45};
        int[] nums2 = {3,4,6,9,11,13};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergeLength = nums1.length + nums2.length;
        int[] mergeArray = new int[mergeLength];
        int index = 0;
        for (int a:nums1){
            mergeArray[index] = a;
            index ++;
        }
        for (int b:nums2){
            mergeArray[index] = b;
            index ++;
        }
        double midValue;
        Arrays.sort(mergeArray);
        int midIndex = mergeLength/2;
        int mid = mergeLength % 2;
        if (mid % 2 == 0){
            midValue = (double) (mergeArray[midIndex-1] + mergeArray[midIndex])/2;
        }else {
            midValue = mergeArray[midIndex];
        }
        return midValue;
    }
}
