package com.exercise.algorithm.day;


public class SolveEquation {

    public String solveEquation(String equation) {
        int equalSignIndex = equation.indexOf("=");
        //等号左边
        int leftCoefficient = 0;
        int leftConstant = 0;
        for (int i = 0; i < equalSignIndex;){
            char c = equation.charAt(i);
            if (c == 'x'){
                leftCoefficient++;
                i++;
            } else if (c == '+' || c == '-'){
                boolean hasVariable = false;
                StringBuilder stringBuilder = new StringBuilder();
                int j = i + 1;
                for (; j < equalSignIndex; j++){
                    char curChar = equation.charAt(j);
                    if (curChar == 'x'){
                        i = j + 1;
                        hasVariable = true;
                        break;
                    }
                    if (curChar == '+' || curChar == '-'){
                        i = j;
                        break;
                    }
                    if (Character.isDigit(curChar)){
                        stringBuilder.append(curChar);
                    }
                }
                if (stringBuilder.length() == 0){
                    stringBuilder.append(1);
                }
                int temp = Integer.parseInt(stringBuilder.toString());
                if (hasVariable){
                    if (c == '+'){
                        leftCoefficient += temp;
                    }else {
                        leftCoefficient -= temp;
                    }
                }else {
                    if (c == '+'){
                        leftConstant += temp;
                    }else {
                        leftConstant -= temp;
                    }
                }
            }else if (Character.isDigit(c)){
                StringBuilder stringBuilder = new StringBuilder();
                boolean tempVariable = false;
                stringBuilder.append(c);
                int j = i+1;
                for (; j < equalSignIndex; j++){
                    char curChar = equation.charAt(j);
                    if (Character.isDigit(curChar)){
                        stringBuilder.append(curChar);
                    }else if (curChar == '+' || curChar == '-'){
                        break;
                    }else if (curChar == 'x'){
                        tempVariable = true;
                        break;
                    }
                }
                if (tempVariable){
                    leftCoefficient += Integer.parseInt(stringBuilder.toString());
                }else {
                    leftConstant += Integer.parseInt(stringBuilder.toString());
                }
                i = j;
            }
        }
        System.out.println(leftCoefficient);
        System.out.println(leftConstant);
        // 等号右边
        int rightCoefficient = 0;
        int rightConstant = 0;
        for (int k = equalSignIndex + 1; k < equation.length();){
            char c = equation.charAt(k);
            if (c == 'x'){
                rightCoefficient++;
                k++;
            } else if (c == '+' || c == '-'){
                boolean hasVariable = false;
                StringBuilder stringBuilder = new StringBuilder();
                int j = k + 1;
                for (; j < equation.length(); j++){
                    char curChar = equation.charAt(j);
                    if (curChar == 'x'){
                        k = j + 1;
                        hasVariable = true;
                        break;
                    }
                    if (curChar == '+' || curChar == '-'){
                        k = j;
                        break;
                    }
                    if (Character.isDigit(curChar)){
                        stringBuilder.append(curChar);
                    }
                }
                if (stringBuilder.length() == 0){
                    stringBuilder.append(1);
                }
                int temp = Integer.parseInt(stringBuilder.toString());
                if (hasVariable){
                    if (c == '+'){
                        rightCoefficient += temp;
                    }else {
                        rightCoefficient -= temp;
                    }
                }else {
                    if (c == '+'){
                        rightConstant += temp;
                    }else {
                        rightConstant -= temp;
                    }
                }
            }else if (Character.isDigit(c)){
                StringBuilder stringBuilder = new StringBuilder();
                boolean tempVariable = false;
                stringBuilder.append(c);
                int j = k +1;
                for (; j < equation.length(); j++){
                    char curChar = equation.charAt(j);
                    if (Character.isDigit(curChar)){
                        stringBuilder.append(curChar);
                    }else if (curChar == '+' || curChar == '-'){
                        break;
                    }else if (curChar == 'x'){
                        tempVariable = true;
                        break;
                    }
                }
                if (tempVariable){
                    rightCoefficient += Integer.parseInt(stringBuilder.toString());
                }else {
                    rightConstant += Integer.parseInt(stringBuilder.toString());
                }
                k = j;
            }
        }
        System.out.println(rightCoefficient);
        System.out.println(rightConstant);
        return "";
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("x+5-3+x=6+x-2"));
    }
}
