package com.exercise.algorithm.day;

/**
 * @ClassName Fib1
 * @Description 斐波那列数
 * @Author yeqiang
 * @Date 2022/7/7 5:14 PM
 * @Version 1.0
 **/
public class Fib1 {

    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++){
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Fib1 fib1 = new Fib1();
        for (int i = 0; i <= 30; i++){
            System.out.println(fib1.fib(i));
        }
    }
}
