package com.exercise.algorithm.day;

/**
 * @ClassName GcdOfStrings
 * @Description 字符串的最大共因子
 * @Author yeqiang
 * @Date 2023/4/16 23:46
 * @Version 1.0
 **/
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))){
            return "";
        }
        return str1.substring(0, gcd(str1.length(),  str2.length()));
    }

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcd2(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        System.out.println(gcdOfStrings.gcdOfStrings("abcabc", "abc"));
        System.out.println(gcdOfStrings.gcdOfStrings("abc", "abcabc"));
        System.out.println(gcdOfStrings.gcdOfStrings("abc", "abca2bc"));
    }
}
