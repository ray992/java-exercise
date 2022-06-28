package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName KWeakestRows
 * @Description 矩阵中战斗力最弱的 K 行
 * @Author yeqiang
 * @Date 2021/8/1 上午9:53
 * @Version 1.0
 **/
public class KWeakestRows {



    public int[] kWeakestRows(int[][] mat, int k) {
        int[] kArray = new int[k];
        TreeMap<Integer, List<Integer>> attackMap = new TreeMap<>();
        for (int i = 0; i < mat.length; i++){
            int army = 0;
            for (int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == 1){
                    army++;
                }
                if (mat[i][j] == 0){
                    break;
                }
            }
            if (attackMap.containsKey(army)){
                attackMap.get(army).add(i);
            }else {
                List<Integer> rowList = new ArrayList<>();
                rowList.add(i);
                attackMap.put(army, rowList);
            }
        }
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> map:attackMap.entrySet()){
            List<Integer> rowList = map.getValue();
            boolean terminal = false;
            for (Integer row:rowList){
                if ((i+1) > k){
                    terminal = true;
                    break;
                }
                kArray[i] = row;
                i++;
            }
            if (terminal){
                break;
            }
        }
        return kArray;
    }

    public static void main(String[] args) {
        //int[][] mat = {{1,1,0,0,0},{1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0},{1,1,1,1,1}};
        int[][] mat = {{1,0,0,0},{1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[] result = kWeakestRows.kWeakestRows(mat, 2);
        for (int row:result){
            System.out.print(row);
        }
    }
}
