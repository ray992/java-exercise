package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName PacificAtlantic
 * @Description 太平洋大西洋水流问题
 * @Author yeqiang
 * @Date 2022/4/27 1:26 PM
 * @Version 1.0
 **/
public class PacificAtlantic {

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        this.m = m;
        this.n = n;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++){
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++){
            dfs(0, j, pacific);
        }
        for (int i = 0;i < m ; i++){
            dfs(i, n-1, atlantic);
        }
        for (int j = 0; j < n-1; j++){
            dfs(m-1, j , atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }
        return ans;
    }


    public void bfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0], newCol = cell[1] + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[cell[0]][cell[1]] && !ocean[newRow][newCol]) {
                    ocean[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    public void dfs(int row, int col, boolean[][] used){
        if (used[row][col]){
            return;
        }
        used[row][col] = true;
        for (int[] dir:dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, used);
            }
        }
    }

    public static void main(String[] args) {

    }
}
