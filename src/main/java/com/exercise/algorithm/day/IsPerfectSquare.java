package com.exercise.algorithm.day;

/**
 * @ClassName IsPerfectSquare
 * @Description 有效的完全平方数
 * @Author yeqiang
 * @Date 2021/11/4 下午9:18
 * @Version 1.0
 **/
public class IsPerfectSquare {

    //牛顿迭代法
    public boolean isPerfectSquare(int num) {
        double x0 = num;
        while (true) {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6) {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare(100));
    }
}
