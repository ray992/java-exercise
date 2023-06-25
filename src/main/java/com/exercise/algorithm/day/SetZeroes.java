package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if (matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if (rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(new int[][]{ {1,1,1}, {1,0,1}, {1,1,1} });
    }
}
