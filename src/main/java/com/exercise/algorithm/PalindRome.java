package com.exercise.algorithm;

/**
 * @ClassName PalindRome
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/3 9:09 下午
 * @Version 1.0
 **/
public class PalindRome {

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.startsWith("-") || s.startsWith("+")){
            return false;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (reverse.equals(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-123321));
    }
}
