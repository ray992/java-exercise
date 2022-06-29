package com.exercise.algorithm.day;

/**
 * @ClassName CountNumbersWithUniqueDigits
 * @Description 统计各位数字都不同的数字个数
 * @Author yeqiang
 * @Date 2022/4/11 1:11 PM
 * @Version 1.0
 **/
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum = sum + perNumberDiff(i);
        }
        return sum;
    }

    public int perNumberDiff(int n){
        if (n == 1){
            return 10;
        }
        if (n == 2){
            return 9 * 9;
        }
        if (n == 3){
            return 9*9*8;
        }
        if (n == 4){
            return 9*9*8*7;
        }
        if (n == 5){
            return 9 * 9* 8 * 7 * 6;
        }
        if (n == 6){
            return 9 * 9* 8 * 7 * 6 * 5;
        }
        if (n == 7){
            return 9 * 9* 8 * 7 * 6 * 5 * 4;
        }
        if (n == 8){
            return 9 * 9* 8 * 7 * 6 * 5 * 4 * 3;
        }
        return 0;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(3));
    }
}
