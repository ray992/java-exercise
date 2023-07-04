package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LenLongestFibSubseq
 * @Description 最长的斐波那列子序列的长度
 * @Author yeqiang
 * @Date 2022/7/9 8:39 AM
 * @Version 1.0
 **/
public class LenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num:arr){
            numSet.add(num);
        }
        int longest = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                int p = arr[i];
                int q = arr[j];
                int sum = p + q;
                int tempCount = 2;
                boolean status = false;
                while (numSet.contains(sum)){
                    status = true;
                    tempCount++;
                    p = q;
                    q = sum;
                    sum = p + q;
                }
                longest = !status ? longest: Math.max(longest, tempCount);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LenLongestFibSubseq lenLongestFibSubseq = new LenLongestFibSubseq();
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        System.out.println(lenLongestFibSubseq.lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50})); // 4, 14, 18, 32, 50
    }
}
