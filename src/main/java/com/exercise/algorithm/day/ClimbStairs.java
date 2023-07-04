package com.exercise.algorithm.day;

/**
 * @ClassName ClimbStairs
 * @Description 爬楼梯
 * @Author yeqiang
 * @Date 2022/7/7 5:21 PM
 * @Version 1.0
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] method = new int[n];
        method[0] = 1;
        method[1] = 2;
        for (int i = 2; i <= n; i++){
            method[i] = method[i - 2] + method[i -1];
        }
        return method[n -1];
    }
}
