package com.exercise.algorithm.day;

/**
 * @ClassName DigitSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/17 10:30 AM
 * @Version 1.0
 **/
public class DigitSum {

    public String digitSum(String s, int k) {
        if (s.length() <= k){
            return s;
        }
        int count = 0;
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean fullStatus = false;
        for (int i = 0; i < s.length(); i++){
            sum = sum + Integer.parseInt(String.valueOf(s.charAt(i)));
            count++;
            fullStatus = false;
            if (count == k){
                stringBuilder.append(sum);
                count = 0;
                sum = 0;
                fullStatus = true;
            }
        }
        if (!fullStatus){
            stringBuilder.append(sum);
        }
        return digitSum(stringBuilder.toString(), k);
    }

    public static void main(String[] args) {
        DigitSum digitSum = new DigitSum();
        System.out.println(digitSum.digitSum("11111222223", 3));
        System.out.println(digitSum.digitSum("00000000", 3));
        System.out.println(digitSum.digitSum("1234", 2));
    }
}
