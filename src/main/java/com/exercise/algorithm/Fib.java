package com.exercise.algorithm;

/**
 * @ClassName Fib
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午5:05
 * @Version 1.0
 **/
public class Fib {

    //0 1 1 2 3


    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int l2 = 1,  l1 = 1;
        int curVal = 0;
        int index = 2;
        while(index < n){
            curVal = l1 + l2;
            l2 = l1;
            l1 = curVal;
            index++;
        }
        return curVal;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        //System.out.println(fib.fib(2));
        //System.out.println(fib.fib(3));
        System.out.println(fib.fib(4));
        //System.out.println(fib.fib(10));
    }
}
