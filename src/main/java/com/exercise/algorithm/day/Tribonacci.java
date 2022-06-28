package com.exercise.algorithm.day;

/**
 * @ClassName Tribonacci
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/8 上午9:30
 * @Version 1.0
 **/
public class Tribonacci {

    public int tribonacci(int n) {
        int n0 = 0, n1 = 1, n2 = 1;
        if (n == 0){
            return n0;
        }
        if (n == 1 || n == 2){
            return n1|n2;
        }
        int t0 = 0, t1 = 1, t2 = 1 , temp = 0;
        int i = 3;
        int result = 0;
        while (i <= n){
            result = t0 + t1 + t2; // t2 = result , t1 = t2, t0 = t1
            temp = result;
            t0 = t1;
            t1 = t2;
            t2 = temp;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(4));
    }
}
