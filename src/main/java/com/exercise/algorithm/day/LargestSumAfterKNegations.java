package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName LargestSumAfterKNegations
 * @Description K次取反后最大化的数组和
 * @Author yeqiang
 * @Date 2021/12/3 上午9:55
 * @Version 1.0
 **/
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
        }

        while (k > 0) {
            int num = heap.poll();
            if (num < 0) {
                // 负数反转再放回去
                heap.offer(-num);
                k--;
            } else {
                // 正数或0
                if (k % 2 != 0) {
                    // k为奇数，反转放回去
                    heap.offer(-num);
                } else {
                    // k为偶数，原数放回去
                    heap.offer(num);
                }
                break;
            }
        }

        int ans = 0;
        while (!heap.isEmpty()) {
            ans += heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        //System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{4,2,3}, 1));
        //System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
        //System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
        //System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{1,3,2,6,7,9}, 3));
        System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 7));
    }
}
