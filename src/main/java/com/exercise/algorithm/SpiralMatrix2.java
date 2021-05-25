package com.exercise.algorithm;

import java.util.Arrays;

/**
 * @ClassName SpiralMatrix2
 * @Description 螺旋矩阵
 * @Author yeqiang
 * @Date 2021/3/16 9:55 下午
 * @Version 1.0
 **/
public class SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {

            for (int i = j; i < n - j; i++){
                arr[j][i] = c++;
            }
            for (int i = j + 1; i < n - j; i++){
                arr[i][n - j - 1] = c++;
            }
            for (int i = n - j - 2; i >= j; i--){
                arr[n - j - 1][i] = c++;
            }
            for (int i = n -j - 2; i > j; i--){
                arr[i][j] = c++;
            }

            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
