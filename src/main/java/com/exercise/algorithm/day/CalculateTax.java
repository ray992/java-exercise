package com.exercise.algorithm.day;

/**
 * @ClassName CalculateTax
 * @Description 计算应缴税款总额
 * @Author yeqiang
 * @Date 2023/1/23 15:33
 * @Version 1.0
 **/
public class CalculateTax {

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int preUpper = 0;
        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];
            if (income < upper){
                tax += (income - preUpper) * percent / 100d;
                break;
            }else {
                tax += (upper - preUpper) * percent / 100d;
            }
            preUpper = upper;
        }
        return tax;
    }

    public static void main(String[] args) {
        CalculateTax calculateTax = new CalculateTax();
        int[][] brackets = {{3,50},{7,10},{12,25}};
        System.out.println(calculateTax.calculateTax(brackets, 10));
        int[][] brackets2 = {{1,0},{4,25},{5,50}};
        System.out.println(calculateTax.calculateTax(brackets2, 2));
    }
}
