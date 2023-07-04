package com.exercise.algorithm.day;

/**
 * @ClassName SolveEquation
 * @Description 求解方程
 * @Author yeqiang
 * @Date 2022/8/10 23:20
 * @Version 1.0
 **/
public class SolveEquation {

    public String solveEquation(String equation) {
        equation = equation.replaceAll("-", "+-");
        int equalSignIndex = equation.indexOf("=");
        String leftExpression = equation.substring(0, equalSignIndex);
        String rightExpression = equation.substring(equalSignIndex + 1);
        String[] leftArray = leftExpression.split("[+]");
        int constantLeft = 0;
        int coefficientLeft = 0;
        for (String left:leftArray){
            if (left.equals("")){
                continue;
            }
            if (left.contains("x")){
                if (left.length() == 1){
                    coefficientLeft += 1;
                }else {
                    left = left.substring(0, left.lastIndexOf("x"));
                    if (left.equals("-")){
                        left = left.concat("1");
                    }
                    coefficientLeft += Integer.parseInt(left);
                }
            }else {
                constantLeft += Integer.parseInt(left);
            }
        }
        int constantRight = 0;
        int coefficientRight = 0;
        String[] rightArray = rightExpression.split("[+]");
        for (String right:rightArray){
            if (right.equals("")){
                continue;
            }
            if (right.contains("x")){
                if (right.length() == 1){
                    coefficientRight += 1;
                }else {
                    right = right.substring(0, right.lastIndexOf("x"));
                    if (right.equals("-")){
                        right = right.concat("1");
                    }
                    coefficientRight += Integer.parseInt(right);
                }
            }else {
                constantRight += Integer.parseInt(right);
            }
        }
        if (coefficientLeft != coefficientRight){
            return "x=" +(constantRight - constantLeft) / (coefficientLeft - coefficientRight);
        }else {
            if (constantLeft == constantRight){
                return "Infinite solutions";
            }else {
                return "No solution";
            }
        }
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation.solveEquation("x=x"));
        System.out.println(solveEquation.solveEquation("2x=x"));
        System.out.println(solveEquation.solveEquation("x+5=x-3"));
        System.out.println(solveEquation.solveEquation("-x=-3"));
    }
}
