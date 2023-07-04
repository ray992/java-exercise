package com.exercise.algorithm.day;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName FractionAddition
 * @Description 分数加减运算
 * @Author yeqiang
 * @Date 2022/7/27 10:32 PM
 * @Version 1.0
 **/
public class FractionAddition {

    public String fractionAddition(String expression) {
        Deque<Character> deque = new LinkedList<>();
        int n = expression.length();
        int denominator = 1; //分母
        int molecular = 0; //分子
        for (int i = 0; i < n;i++){
            char curChar = expression.charAt(i);
            if (curChar != '/'){
                deque.addLast(curChar);
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                while (!deque.isEmpty()){
                    stringBuilder.append(deque.pollFirst());
                }
                //当前分子
                int curMolecular = Integer.parseInt(stringBuilder.toString());
                StringBuilder stringBuilder1 = new StringBuilder();
                int j = i + 1;
                for (;j < n; j++){
                    char nextChar = expression.charAt(j);
                    if (nextChar == '+' || nextChar == '-'){
                        break;
                    }
                    stringBuilder1.append(nextChar);
                }
                //当前分母
                int curDenominator = Integer.parseInt(stringBuilder1.toString());
                molecular = curMolecular*denominator + molecular*curDenominator;
                denominator= curDenominator * denominator;
                i = --j;
            }
        }
        if (molecular == 0){
            return "0/1";
        }
        int absMolecular = Math.abs(molecular);
        int absDenominator = Math.abs(denominator);
        int maxDivisor = gcd(absDenominator, absMolecular);
        return molecular/maxDivisor + "/" + denominator/maxDivisor;
    }

    public static void main(String[] args) {
        FractionAddition fractionAddition = new FractionAddition();
        System.out.println(fractionAddition.fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition.fractionAddition("1/3-1/2"));
    }

    int gcd(int a, int b){
        if (a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }
}
