package com.exercise.algorithm.competition.intsig;

import java.util.*;

/**
 * @ClassName MinSumSquareDiff
 * @Description 最小差值平方和
 * @Author yeqiang
 * @Date 2022/7/9 10:40 PM
 * @Version 1.0
 **/
public class MinSumSquareDiff {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n1 = nums1.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n1; i++){
            priorityQueue.offer(Math.abs(nums1[i] - nums2[i]));
        }
        int k = k1 + k2;
        while (!priorityQueue.isEmpty() && k > 0){
            int cur = priorityQueue.poll();
            if (cur == 0){
                break;
            }
            if (cur - 1 > 0){
                priorityQueue.offer(cur - 1);
            }
            k--;
        }
        long res = 0;
        while (!priorityQueue.isEmpty()){
            int cur = priorityQueue.poll();
            res += (long)cur * cur;
        }
        return res;
    }

    public long minSumSquareDiff2(int[] nums1, int[] nums2, int k1, int k2) {
        int n1 = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxDiff = 0;
        for (int i = 0 ; i < n1; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(diff, maxDiff);
            map.put(diff, map.getOrDefault(diff, 0 )+ 1);
        }
        int k = k1 + k2;
        while (k > 0){
            if (maxDiff == 0){
                break;
            }
            int count = map.get(maxDiff);
            if (k - count >= 0){
                k = k - count;
                map.remove(maxDiff);
                maxDiff--;
                map.put(maxDiff, map.getOrDefault(maxDiff, 0)+count);
            }else {
                map.put(maxDiff, count - k);
                maxDiff--;
                map.put(maxDiff, map.getOrDefault(maxDiff, 0)+k);
                k = 0;
            }
        }
        long res = 0;
        for (Map.Entry<Integer,Integer> curMap:map.entrySet()){
            int diff = curMap.getKey();
            int count = curMap.getValue();
            res +=  (long)(((long) diff *diff) * count);
        }
        return res;
    }

    public static void main(String[] args) {
        MinSumSquareDiff minSumSquareDiff = new MinSumSquareDiff();
        System.out.println(minSumSquareDiff.minSumSquareDiff2(new int[]{10,10,10,11,5}, new int[]{1,0,6,6,1}, 11, 27));
        System.out.println(minSumSquareDiff.minSumSquareDiff2(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 1, 1));
        System.out.println(minSumSquareDiff.minSumSquareDiff2(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 10, 5));
    }
}
