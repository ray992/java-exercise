package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OddCells
 * @Description 奇数值单元格的树木
 * @Author yeqiang
 * @Date 2022/7/12 8:26 AM
 * @Version 1.0
 **/
public class OddCells {

    public int oddCells(int m, int n, int[][] indices) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int[] indic:indices){
            int r = indic[0];
            int c = indic[1];
            rowMap.put(r, rowMap.getOrDefault(r, 0)+1);
            colMap.put(c, colMap.getOrDefault(c, 0)+1);
        }
        int[][] array = new int[m][n];
        for (Map.Entry<Integer, Integer> map:rowMap.entrySet()){
            int row = map.getKey();
            int addCount = map.getValue();
            for (int j = 0; j < n; j++){
                array[row][j] = array[row][j] + addCount;
            }
        }
        for (Map.Entry<Integer, Integer> map:colMap.entrySet()){
            int col = map.getKey();
            int addCount = map.getValue();
            for (int i = 0; i < m; i++){
                array[i][col] = array[i][col] + addCount;
            }
        }
        int oddCount = 0;
        for (int[] arr:array){
            for (int p:arr){
                if ((p & 1) != 0){
                    oddCount++;
                }
            }
        }
        return oddCount;
    }

    public static void main(String[] args) {
        OddCells oddCells = new OddCells();
        System.out.println(oddCells.oddCells(2,3,new int[][]{ {0,1}, {1,1} }));
        System.out.println(oddCells.oddCells(2,2,new int[][]{ {1,1}, {0,0} }));
    }
}
