package com.exercise.algorithm.day;

/**
 * @ClassName Matrix2
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/30 10:38 下午
 * @Version 1.0
 **/
public class Matrix2 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        boolean rowAscOrder = true;
        boolean moreThanStatus = true;
        boolean targetStatus = false;
        int rowBottom = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;
        int n = matrix[0].length;
        for(int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (j > 0 && matrix[i][j] < temp){
                    rowAscOrder = false;
                    break;
                }
                if (j < n - 1){
                    temp = matrix[i][j];
                }
                if (j == 0 && i > 0){
                    if (matrix[i][j] <= rowBottom){
                        moreThanStatus = false;
                        break;
                    }
                }
                if (matrix[i][j] == target){
                    targetStatus = true;
                }
                if (j == n -1 ){
                    rowBottom = matrix[i][j];
                }
            }
        }
        return rowAscOrder && moreThanStatus && targetStatus;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{3}};
        System.out.println(searchMatrix(matrix, 1));
    }
}
