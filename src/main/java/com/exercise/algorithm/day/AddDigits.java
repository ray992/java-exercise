package com.exercise.algorithm.day;

/**
 * 各位相加
 */
public class AddDigits {

    int res = 0;

    public int addDigits(int num) {
        operate(String.valueOf(num));
        return res;
    }

    public void operate(String num){
        char[] chars = num.toCharArray();
        int temp = 0;
        for (char c:chars){
            temp+=Integer.parseInt(String.valueOf(c));
        }
        if (temp < 10){
            res = temp;
            return;
        }
        operate(String.valueOf(temp));
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(0));
        int a = 2 << 30;
        a = a -1;
        System.out.println(addDigits.addDigits((a)));
    }


}
