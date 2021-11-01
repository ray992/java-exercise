package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName SearchMatrix
 * @Description 搜索二维矩阵
 * @Author yeqiang
 * @Date 2021/10/25 上午9:42
 * @Version 1.0
 **/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean xTag = false;
        int index = 0;
        for (int i = 0; i < n; i++){
            if (matrix[0][i] == target){
                return true;
            }
            if (i < (n-1) && matrix[0][i] < target && matrix[0][i+1] > target){
                xTag = true;
                index = i;
                break;
            }
            if (i == (n - 1) && matrix[0][i] <  target){
                xTag = true;
                index = i;
                break;
            }
        }
        if (xTag){
            for (int j = 1; j < m; j++){
                if (matrix[j][index] == target){
                    return true;
                }
            }
        }
        boolean yTag = false;
        for (int k = 0; k < m ; k++){
            if (matrix[k][0] == target){
                return true;
            }
            if (k < (m-1) && matrix[k][0] < target && matrix[k+1][0] > target){
                yTag = true;
                index = k;
                break;
            }
            if (k == (m -1) && matrix[k][0] < target){
                yTag = true;
                index = k;
                break;
            }
        }
        if (yTag){
            for (int t = 1; t < n; t++){
                if (matrix[index][t] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target){
        Map<Integer, int[]> rowMap = new LinkedHashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int start, end;
        for (int i = 0; i < m; i++){
            start = matrix[i][0];
            end = matrix[i][n-1];
            rowMap.put(i, new int[]{start, end});
        }
        List<Integer> validList = new ArrayList<>();
        for (Map.Entry<Integer, int[]> map:rowMap.entrySet()){
            int key = map.getKey();
            int[] val = map.getValue();
            if (val[0] <= target && val[1] >= target){
                validList.add(key);
            }
        }
        if (validList.size() == 0){
            return false;
        }
        for (Integer rowIndex : validList) {
            for (int j = 0; j < n; j++) {
                if (matrix[rowIndex][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix1(new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}}, 17));
        System.out.println(searchMatrix.searchMatrix1(new int[][]{{1,3,5,7,9}, {2,4,6,8,10}, {11,13,15,17,19}, {12,14,16,18,20}, {21,22,23,24,25}}, 13));
    }
}
