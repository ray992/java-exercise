package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName HighestPeak
 * @Description 地图中的最高点
 * @Author yeqiang
 * @Date 2022/1/29 上午10:32
 * @Version 1.0
 **/
public class HighestPeak {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                result[i][j] = -1;
            }
        }
        int total = m*n;
        int cover = 0;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (isWater[i][j] == 1){
                    result[i][j] = 0;
                    cover++;
                }
            }
        }
        while (cover < total){
            for (int i = 0; i < m; i ++){
                for (int j = 0; j < n; j++){
                    if (result[i][j] == 0){
                        continue;
                    }
                    int west = -1;
                    int east = -1;
                    int north = -1;
                    int south = -1;
                    if (i > 0){
                        north = result[i-1][j];
                    }
                    if (i < (m-1)){
                        south = result[i+1][j];
                    }
                    if (j > 0){
                        west = result[i][j-1];
                    }
                    if (j < (n-1)){
                        east = result[i][j+1];
                    }
                    if (west == -1 && east == -1 && north == -1 && south == -1){
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    if (west != -1 && west < min){
                        min  = west;
                    }
                    if (east != -1 && east < min){
                        min  = east;
                    }
                    if (north != -1 && north < min){
                        min = north;
                    }
                    if (south != -1 && south < min){
                        min = south;
                    }
                    result[i][j] = min + 1;
                    cover++;
                }
            }
        }
        return result;
    }

    public int[][] highestPeak2(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                ans[i][j] = isWater[i][j] == 1 ? 0 :-1;
                if (isWater[i][j] == 1){
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!deque.isEmpty()){
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir:dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue; //边界判断
                }
                if (ans[nx][ny] != -1){
                    continue; //避免重复赋值
                }
                ans[nx][ny] = ans[x][y] + 1;
                deque.addLast(new int[]{nx, ny}); //向外扩散
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        HighestPeak highestPeak = new HighestPeak();
        System.out.println(Arrays.deepToString(highestPeak.highestPeak2(new int[][]{{0, 1}, {0, 0}})));
        System.out.println(Arrays.deepToString(highestPeak.highestPeak2(new int[][]{{0,0,1}, {1,0,0}, {0,0,0}})));
    }
}
