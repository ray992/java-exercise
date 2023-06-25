package com.exercise.algorithm.offer;

/**
 * 二维数组查找
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0){
            return false;
        }
        int m = matrix[0].length;
        if (m == 0){
            return false;
        }
        for (int i = 0; i < n; i++){
            int left = 0;
            int right = m - 1;
            while (left <= right){
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] < target){
                    left = mid + 1;
                }else if (matrix[i][mid] > target){
                    right = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(new int[][]{ {1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}  }, 105));
    }
}
