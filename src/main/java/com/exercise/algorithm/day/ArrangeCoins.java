package com.exercise.algorithm.day;

/**
 * @ClassName ArrangeCoins
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/10 下午8:12
 * @Version 1.0
 **/
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int perCount = 1;
        int count = 0;
        while (n > 0){
            n = n - perCount;
            if (n >= 0){
                perCount++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(5));
        System.out.println(arrangeCoins.arrangeCoins(8));
        System.out.println(arrangeCoins.arrangeCoins(1));
    }
}
