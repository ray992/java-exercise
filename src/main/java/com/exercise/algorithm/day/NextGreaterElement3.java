package com.exercise.algorithm.day;

/**
 * @ClassName NextGreaterElement3
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/3 7:58 AM
 * @Version 1.0
 **/
public class NextGreaterElement3 {

    public int nextGreaterElement(int n) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((long)Math.pow(2, 31)-1);
        long res = 1;
        for (int i = 9; i >= 1; i--){
            res *= i;
        }
        System.out.println(res);
    }
}
