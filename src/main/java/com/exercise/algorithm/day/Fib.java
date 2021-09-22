package com.exercise.algorithm.day;

import java.math.BigDecimal;

/**
 * @ClassName Fib
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/4 上午10:29
 * @Version 1.0
 **/
public class Fib {

    public int fib(int n) {
        BigDecimal a0 = new BigDecimal(0), a1 = new BigDecimal(1), answer = new BigDecimal(-1);
        if (n == 0){
            answer = a0;
        }else if (n == 1){
            answer = a1;
        }else {
            for (int i = 2; i <= n; i++){
                answer = a0.add(a1);
                a0 = a1;
                a1 = answer;
            }
        }
        return answer.remainder(new BigDecimal(1000000007)).intValue();
    }

    public int fib1(int n) {
        int a0 = 0, a1 = 1, answer = -1;
        if (n == 0){
            answer = a0;
        }else if (n == 1){
            answer = a1;
        }else {
            for (int i = 2; i <= n; i++){
                answer = (a0+a1)%1000000007;
                a0 = a1;
                a1 = answer;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        //System.out.println(fib.fib(2));
        //System.out.println(fib.fib(5));
        //System.out.println(fib.fib(10));
        System.out.println(fib.fib1(95));
        System.out.println(fib.fib(100));
    }
}
