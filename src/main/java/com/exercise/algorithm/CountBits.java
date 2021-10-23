package com.exercise.algorithm;

import java.util.Arrays;

/**
 * @ClassName CountBits
 * @Description 前n个数字二进制中1的个数
 * @Author yeqiang
 * @Date 2021/10/10 下午8:25
 * @Version 1.0
 **/
public class CountBits {



    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <=n; i++){
            res[i] = getOneCount(i);
        }
        return res;
    }

    public int getOneCount(int n){
        int times = 0;
        while (n > 0){
            n = n & (n-1);
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(Arrays.toString(countBits.countBits(100)));
    }
}
