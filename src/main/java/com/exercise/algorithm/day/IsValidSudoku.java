package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName IsValidSudoku
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/17 下午4:15
 * @Version 1.0
 **/
public class IsValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowDataSet = new HashSet<>();
        Map<Integer, Set<Character>> colDataSetMap = new HashMap<>();
        Map<String, Set<Character>> innerDataSetMap = new HashMap<>();
        boolean result = true;
        for (int i = 0; i < board.length; i++){
            rowDataSet.clear();
            for (int j = 0; j < board[i].length; j++){
                char curChar = board[i][j];
                if (curChar == '.'){
                    continue;
                }
                if (!rowDataSet.add(curChar)){
                    result =  false;
                    break;
                }
                if (!colDataSetMap.containsKey(j)){
                    Set<Character> colSet = new HashSet<>();
                    colSet.add(curChar);
                    colDataSetMap.put(j, colSet);
                }else {
                    Set<Character> curColSet = colDataSetMap.get(j);
                    if (!curColSet.add(curChar)){
                        result =  false;
                        break;
                    }
                }
                if (i<=2 && j <=2){
                    if (!innerDataSetMap.containsKey("A")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("A", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("A");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=2 && j <=5){
                    if (!innerDataSetMap.containsKey("B")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("B", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("B");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=2 && j <=8){
                    if (!innerDataSetMap.containsKey("C")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("C", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("C");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=5 && j <=2){
                    if (!innerDataSetMap.containsKey("D")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("D", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("D");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=5 && j <=5){
                    if (!innerDataSetMap.containsKey("E")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("E", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("E");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=5 && j <=8){
                    if (!innerDataSetMap.containsKey("F")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("F", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("F");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=8 && j <=2){
                    if (!innerDataSetMap.containsKey("G")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("G", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("G");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=8 && j <=5){
                    if (!innerDataSetMap.containsKey("H")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("H", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("H");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
                if (i<=8 && j <=8){
                    if (!innerDataSetMap.containsKey("I")){
                        Set<Character> innerSet = new HashSet<>();
                        innerSet.add(curChar);
                        innerDataSetMap.put("I", innerSet);
                    }else {
                        Set<Character> innerColSet = innerDataSetMap.get("I");
                        if (!innerColSet.add(curChar)){
                            result =  false;
                            break;
                        }
                    }
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
      char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}};
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));
    }
}
