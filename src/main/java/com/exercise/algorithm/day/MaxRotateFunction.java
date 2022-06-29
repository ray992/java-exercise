package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName MaxRotateFunction
 * @Description 旋转函数
 * @Author yeqiang
 * @Date 2022/4/22 1:14 PM
 * @Version 1.0
 **/
public class MaxRotateFunction {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 1; i++){
            int tempSum = 0;
            int pre = n - i;
            if (pre == n){
                pre = 0;
            }
            for (int t = 0; t <= n - 1; t++){
                tempSum+=t*nums[pre];
                pre++;
                if (pre == n ){
                    pre = 0;
                }
            }
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }

    //F(k) = F(k-1) + numSum - n*nums[n-1]
    public int maxRotateFunction2(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxRotateFunction maxRotateFunction = new MaxRotateFunction();
        System.out.println(maxRotateFunction.maxRotateFunction2(new int[]{4,3,2,6}));
        System.out.println(maxRotateFunction.maxRotateFunction2(new int[]{100}));
    }
}
