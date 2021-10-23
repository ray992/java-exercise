package com.exercise.algorithm.day;

/**
 * @ClassName Divide
 * @Description 整数除法
 * @Author yeqiang
 * @Date 2021/10/12 上午10:16
 * @Version 1.0
 **/
public class Divide {

    //-2~31, 2~31-1
    public int divide(int dividend, int divisor){
        if (dividend == 0){
            return 0;
        }
        if (divisor == 1 ){
            return dividend;
        }
        if (divisor == -1){
            if (dividend > Integer.MIN_VALUE){
                return -dividend;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)){
            sign = -1;
        }
        a = (a > 0)?a:-a;
        b = (b > 0)?b:-b;
        long res = div(a, b);
        if (sign > 0){
            return (int)Math.min(res, Integer.MAX_VALUE);
        }
        return -(int)res;
    }

    long div(long a, long b){
        if (a < b){
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb+tb) <= a){
            count = count + count;
            tb = tb+tb;
        }
        return count+div(a-tb, b);
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.divide(10,3));
        System.out.println(divide.divide(Integer.MIN_VALUE,-1));
    }

}
