package com.exercise.algorithm;

/**
 * @ClassName IsPowerOfTwo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午3:44
 * @Version 1.0
 **/
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        while (n != 1) {
            int m = n / 2;
            int remain = n % 2;
            if (remain != 0) {
                return false;
            }
            n = m;
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        long i = 0;
        while (true) {
            long val = (long)Math.pow(2, i);
            if (val == n){
                return true;
            }
            if (val > n){
                return false;
            }
            i++;
        }
    }

    //位运算

    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo1(1));
        System.out.println(isPowerOfTwo.isPowerOfTwo1(16));
        System.out.println(isPowerOfTwo.isPowerOfTwo1(3));
        System.out.println(5&4); // 101 100
    }
}
