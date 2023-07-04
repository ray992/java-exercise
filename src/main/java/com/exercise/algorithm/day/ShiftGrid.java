package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShiftGrid
 * @Description 二维网格迁移
 * @Author yeqiang
 * @Date 2022/7/20 10:19 PM
 * @Version 1.0
 **/
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> rowsList = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rowsList.size() > j){
                    rowsList.get(j).add(grid[i][j]);
                }else {
                    List<Integer> colList = new ArrayList<>();
                    colList.add(grid[i][j]);
                    rowsList.add(colList);
                }
            }
        }
        int count = 0;
        while (count < k){
            List<Integer> lastList = rowsList.get(rowsList.size() - 1);
            int lastElement = lastList.get(lastList.size() - 1);
            lastList.remove(lastList.size() - 1);
            lastList.add(0, lastElement);
            rowsList.add(0, lastList);
            rowsList.remove(rowsList.size() - 1);
            count++;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        int size = rowsList.size();
        int colSize = rowsList.get(0).size();
        for (int i = 0; i < size; i++){
            for (int r = 0; r < colSize; r++){
                if (resultList.size() > r){
                    resultList.get(r).add(rowsList.get(i).get(r));
                }else {
                    List<Integer> rowList = new ArrayList<>();
                    rowList.add(rowsList.get(i).get(r));
                    resultList.add(rowList);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();
        System.out.println(shiftGrid.shiftGrid(new int[][]{{1,2,3}, {4,5,6}, {7,8,9} }, 1));
        System.out.println(shiftGrid.shiftGrid(new int[][]{{3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13} }, 4));
    }
}
