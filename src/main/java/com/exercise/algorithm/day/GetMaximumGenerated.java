package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName GetMaximumGenerated
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/23 上午9:19
 * @Version 1.0
 **/
public class GetMaximumGenerated {

    public int getMaximumGenerated(int n) {
        int[] result = new int[n+1];
        if (n == 0){
            return result[0];
        }
        result[0] = 0;
        result[1] = 1;
        int i = 0;
        while (i <= n){
            i++;
            if (2*i >= 2 && 2*i <= n){
                result[2*i] = result[i];
            }
            if ((2*i +1) >= 2 && (2*i+1) <= n){
                result[2*i+1] = result[i+1]+result[i];
            }
        }
        return  Arrays.stream(result).max().getAsInt();
    }

    public static void main(String[] args) {
        GetMaximumGenerated getMaximumGenerated = new GetMaximumGenerated();
        System.out.println(getMaximumGenerated.getMaximumGenerated(7));
        System.out.println(getMaximumGenerated.getMaximumGenerated(2));
        System.out.println(getMaximumGenerated.getMaximumGenerated(3));
    }
}
