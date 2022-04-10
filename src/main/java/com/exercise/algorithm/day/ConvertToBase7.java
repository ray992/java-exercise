package com.exercise.algorithm.day;

import java.util.Stack;

/**
 * 七进制数
 */
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }
        boolean negativeNumber = num < 0;
        StringBuilder res = new StringBuilder();
        while (num != 0){
            res.append(Math.abs(num % 7));
            num = num / 7;
        }
        return negativeNumber? "-"+ res.reverse() :res.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToBase7 convertToBase7 = new ConvertToBase7();
        System.out.println(convertToBase7.convertToBase7(100));
        System.out.println(convertToBase7.convertToBase7(-7));
        System.out.println(convertToBase7.convertToBase7(-8));
    }
}
