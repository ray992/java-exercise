package com.exercise.algorithm.day;

/**
 * @ClassName GetSum
 * @Description 两数之和
 * @Author yeqiang
 * @Date 2021/9/26 上午8:25
 * @Version 1.0
 **/
public class GetSum {

    public int getSum(int a, int b) {
        return (int)Math.sqrt(a*a+2*a*b+b*b);
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(1,2));
        System.out.println(getSum.getSum(2,3));
    }
}
