package com.exercise.algorithm.day;

/**
 * @ClassName ToHex
 * @Description 数字转换为十六进制
 * @Author yeqiang
 * @Date 2021/10/2 上午10:40
 * @Version 1.0
 **/
public class ToHex {

    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        long target = num;
        if (target < 0){
            target = (long) (Math.pow(2, 32) + num);
        }
        StringBuilder sb = new StringBuilder();
        while (target != 0){
           long u = target % 16;
           char c = (char)(u+'0');
           if (u >= 10){
               c = (char)(u - 10 + 'a');
           }
           sb.append(c);
           target = target / 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ToHex toHex = new ToHex();
        System.out.println(toHex.toHex(26));
        System.out.println(toHex.toHex(-100));
        int a = -11;
        System.out.println(a/3);
        System.out.println(a % 3);
    }
}
