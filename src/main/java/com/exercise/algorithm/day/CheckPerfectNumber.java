package com.exercise.algorithm.day;


/**
 * @ClassName CheckPerfectNumber
 * @Description 完美数
 * @Author yeqiang
 * @Date 2021/12/31 上午9:29
 * @Version 1.0
 **/
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num/2+1; i++){
            if (num % i == 0){
                sum+=i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        CheckPerfectNumber checkPerfectNumber = new CheckPerfectNumber();
        System.out.println(checkPerfectNumber.checkPerfectNumber(28));
        System.out.println(checkPerfectNumber.checkPerfectNumber(6));
        System.out.println(checkPerfectNumber.checkPerfectNumber(496));
        System.out.println(checkPerfectNumber.checkPerfectNumber(8128));
    }
}
