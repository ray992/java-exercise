package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Calculator
 * @Description 基本计算器
 * @Author yeqiang
 * @Date 2021/3/10 8:47 下午
 * @Version 1.0
 **/
public class Calculator {

    public static int calculate(String s) {
        s = s.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ","");
        if (s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i <= chars.length - 1) {
            if (chars[i] == '-') {
                if (i == 0){
                    stringBuilder.append("0");
                }
                stringBuilder.append("+").append(chars[i]);
            } else {
                stringBuilder.append(chars[i]);
            }
            i++;
        }
        String newString = stringBuilder.toString();
        String[] s1 = newString.split("\\+");
        int sum = 0;
        for (int j = 0; j < s1.length; j++){
            sum = sum + Integer.parseInt(s1[j]);
        }
        return sum;
    }


    public static int calculate1(String s){
        s = s.replaceAll(" ","") + "+0";
        if (s.startsWith("-")){
            s = "0" + s;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int num = 0;
        char preOperation = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n ; i ++){
            if (Character.isDigit(chars[i])){
                num = num*10 + chars[i] - '0';
            }else {
                switch (preOperation){
                    case '+':
                        stack.add(num);
                        break;
                    case '-':
                        stack.add(-num);
                        break;
                    case '*':
                        stack.add(stack.pop()*num);
                        break;
                    case '/':
                        stack.add(stack.pop()/num);
                    default:
                }
                preOperation = chars[i];
                num = 0;
            }
        }
        int sum1 = 0;
        while (!stack.isEmpty()){
            sum1 = sum1 + stack.pop();
        }
        return sum1;
    }

    public static void main(String[] args) {
        //System.out.println(calculate("- (3 + (4 + 5))"));
        System.out.println(calculate1("3+2*2"));
    }


}
