package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaxCount
 * @Description 范围求和
 * @Author yeqiang
 * @Date 2021/11/7 上午10:13
 * @Version 1.0
 **/
public class MaxCount {

    public int maxCount(int m, int n, int[][] ops) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < ops.length; i++){
            for (int t = 0; t < ops[i][0]; t++){
                for (int r = 0; r < ops[i][1]; r++){
                    matrix[t][r]+=1;
                }
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = -1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                }
                countMap.put(matrix[i][j], countMap.getOrDefault(matrix[i][j], 0)+1);
            }
        }
        return countMap.get(max);
    }

    public static void main(String[] args) {
        MaxCount maxCount = new MaxCount();
        System.out.println(maxCount.maxCount(3,3, new int[][]{{2,2}, {3,3}}));
        System.out.println(maxCount.maxCount(400000,400000, new int[][]{}));
    }
}
