package com.exercise.algorithm.top;

import java.util.PriorityQueue;

public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        for (int n1:nums1){
            p1.offer(n1);
        }
        for (int n2:nums2){
            p1.offer(n2);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        double sum = 0;
        int i = 0;
        if ((l1 + l2) % 2 == 0){
            int mid = (l1 + l2) / 2 ;
            while (i <= mid){
                int p = p1.poll();
                if (i == mid - 1  || i == mid){
                    sum += p;
                }
                i++;
            }
        }else {
            int mid =   (l1 + l2) / 2 + 1;
            while (i < mid){
                int p = p1.poll();
                i++;
                if (i == mid){
                    sum += p;
                }
            }
            return sum;
        }
        return sum / 2;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_4 findMedianSortedArrays4 = new FindMedianSortedArrays_4();
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(new int[]{}, new int[]{2,3}));
    }
}
