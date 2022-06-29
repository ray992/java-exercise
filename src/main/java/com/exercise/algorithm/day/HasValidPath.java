package com.exercise.algorithm.day;

import org.apache.commons.collections.ArrayStack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName HasValidPath
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/8 11:00 AM
 * @Version 1.0
 **/
public class HasValidPath {

    boolean[][][] visited = new boolean[105][105][105];

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (((m + n) & 1) == 0 || grid[0][0] == ')' || grid[m - 1][ n- 1] == '('){
            return false;
        }
        int[][] paths = { {0, 1}, {1, 0} };
        Deque<int[]> dequePathDeque = new ArrayDeque<>();
        visited[0][0][1] = true;
        dequePathDeque.addLast(new int[]{0, 0, 1});
        while (!dequePathDeque.isEmpty()){
            int size = dequePathDeque.size();
            for (int i = 0; i < size; i++){
                int[] pos = dequePathDeque.poll();
                int p0 = pos[0];
                int p1 = pos[1];
                int layer = pos[2];
                for (int[] path:paths){
                    int m1 = p0 + path[0];
                    int n1 = p1 + path[1];
                    if (m1 > m - 1 || n1 > n - 1 ){
                        continue;
                    }
                    char curChar = grid[m1][n1];
                    if (curChar == '('){
                        layer++;
                    }else {
                        layer--;
                    }
                    if (layer < 0 ||  visited[m1][n1][layer]){
                        continue;
                    }
                    visited[m1][n1][layer] = true;
                    if (m1 == m -1 && n1 == n -1 && layer == 0){
                        return true;
                    }
                    dequePathDeque.addLast(new int[]{m1, n1, layer});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((3 & 1) == 1);
        System.out.println((2 & 1) == 1);
    }
}
