package com.exercise.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName MergeArray
 * @Description 合并有序数组
 * @Author yeqiang
 * @Date 2021/8/1 上午11:10
 * @Version 1.0
 **/
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new PriorityQueue<>(nums1.length);
        int t = 0;
        for (int i:nums1){
            queue.add(i);
            t++;
            if (t>=m){
                break;
            }
        }
        t = 0;
        for (int i:nums2){
            queue.add(i);
            t++;
            if (t>=n){
                break;
            }
        }
        t = 0;
        while (!queue.isEmpty()){
            nums1[t] = queue.poll();
            t++;
        }
        for (int val:nums1){
            System.out.println(val);
        }
    }

    //归并排序
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        mergeArray.merge(num1, 3, num2,3);
    }
}
