package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrix
 * @Description 螺旋矩阵
 * @Author yeqiang
 * @Date 2021/3/15 9:12 下午
 * @Version 1.0
 **/
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        boolean isOdd = false;
        if (m % 2 == 0){
            isOdd = true;
        }
        while (j < n && i < m){
            if(isOdd){
                if (i == 1 && j == 0){
                    break;
                }
            }else {
                if (i == 1 && j == n -1){
                    break;
                }
            }

            list.add(matrix[i][j]);
        }
        return list;
    }
}
