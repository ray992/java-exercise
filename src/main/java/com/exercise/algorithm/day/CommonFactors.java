package com.exercise.algorithm.day;

/**
 * 相同因子个数
 */
public class CommonFactors {

    public int commonFactors(int a, int b) {
        int count = 0;
        int min = Math.min(a, b);
        for (int i = 1; i <= min; i++){
            if (a % i == 0 && b % i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CommonFactors commonFactors = new CommonFactors();
        System.out.println(commonFactors.commonFactors(12,6));
    }
}
