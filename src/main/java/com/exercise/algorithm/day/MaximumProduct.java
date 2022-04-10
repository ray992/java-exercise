package com.exercise.algorithm.day;

import java.util.PriorityQueue;

/**
 * @ClassName MaximumProduct
 * @Description 最大乘积
 * @Author yeqiang
 * @Date 2022/4/10 2:14 PM
 * @Version 1.0
 **/
public class MaximumProduct {

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++){
            int num = priorityQueue.poll();
            num = num + 1;
            priorityQueue.offer(num);
        }
        long ans = 1;
        long mod = 1000000007;
        for (int num:priorityQueue){
            ans = (ans * num) % mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        MaximumProduct maximumProduct = new MaximumProduct();
        System.out.println(maximumProduct.maximumProduct(new int[]{0, 4}, 5));
        System.out.println(maximumProduct.maximumProduct(new int[]{6,3, 3, 2}, 2));
        System.out.println(maximumProduct.maximumProduct(new int[]{24,5,64,53,26,38}, 54));
    }
}
