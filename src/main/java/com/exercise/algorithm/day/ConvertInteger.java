package com.exercise.algorithm.day;

/**
 * @ClassName ConvertInteger
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/14 下午11:24
 * @Version 1.0
 **/
public class ConvertInteger {

    public int convertInteger(int A, int B) {
        String bs1 = Integer.toBinaryString(A);
        String bs2 = Integer.toBinaryString(B);
        int n1 = bs1.length();
        int n2 = bs2.length();
        StringBuilder diffStringBuilder = new StringBuilder();
        int i = 0;
        if (n1 > n2){
            while (i < (n1-n2)){
                diffStringBuilder.append("0");
                i++;
            }
            bs2 = diffStringBuilder.toString()+bs2;
        }else if (n1 < n2){
            while (i < (n2-n1)){
                diffStringBuilder.append("0");
                i++;
            }
            bs1 = diffStringBuilder.toString()+bs1;
        }
        int changeCount = 0;
        for (int j = 0; j < bs1.length(); j++){
            if (bs1.charAt(j) != bs2.charAt(j)){
                changeCount++;
            }
        }
        return changeCount;
    }

    public static void main(String[] args) {
        ConvertInteger convertInteger = new ConvertInteger();
        System.out.println(convertInteger.convertInteger(29, 15));
        System.out.println(convertInteger.convertInteger(1, 2));
    }
}
