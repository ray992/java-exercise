package com.exercise.algorithm.day;

/**
 * @ClassName MaxCommonDivisor
 * @Description 最大公约数
 * @Author yeqiang
 * @Date 2021/11/1 下午11:05
 * @Version 1.0
 **/
public class MaxCommonDivisor {

    //辗转相除法，大数除法，性能较低
    public int maxCommonDivisor(int a , int b){
        int r = Math.min(a, b);
        int m = Math.max(a, b);
        while (r != 0){
           int temp = r;
           r = m % r;
           m = temp;
        }
        return m;
    }

    public static void main(String[] args) {
        MaxCommonDivisor maxCommonDivisor = new MaxCommonDivisor();
        System.out.println(maxCommonDivisor.maxCommonDivisor(9, 6));
    }
}
