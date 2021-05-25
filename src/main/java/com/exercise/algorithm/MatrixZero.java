package com.exercise.algorithm;

/**
 * @ClassName MatrixZero
 * @Description 矩阵置零
 * @Author yeqiang
 * @Date 2021/3/21 10:09 下午
 * @Version 1.0
 **/
public class MatrixZero {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m ; i ++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){

                }
            }
        }
    }
}
