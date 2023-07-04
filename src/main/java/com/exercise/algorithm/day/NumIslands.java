package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName NumIslands
 * @Description 岛屿数量
 * @Author yeqiang
 * @Date 2022/7/7 11:24 AM
 * @Version 1.0
 **/
public class NumIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> landList = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int r = 0; r < n; r++){
                if (grid[i][r] == '1'){
                    landList.add(new int[]{i, r});
                }
            }
        }
        int count = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < landList.size(); i++){
            int[] curLand = landList.get(i);
            if (visited[curLand[0]][curLand[1]]){
                continue;
            }
            visited[curLand[0]][curLand[1]] = true;
            deque.offer(curLand);
            while (!deque.isEmpty()){
                int[] land = deque.poll();
                int x = land[0];
                int y = land[1];
                if (x + 1 < m && !visited[x+1][y] && grid[x + 1][y] == '1'){
                    deque.offer(new int[]{x+1, y});
                    visited[x+1][y] = true;
                }
                if (y + 1 < n && !visited[x][y+1] && grid[x][y+1] == '1'){
                    deque.offer(new int[]{x, y+1});
                    visited[x][y + 1] = true;
                }
                if (x - 1 >= 0 && !visited[x -1][y] && grid[x -1][y] == '1'){
                    deque.offer(new int[]{x-1, y});
                    visited[x-1][y] = true;
                }
                if (y - 1 >= 0 && !visited[x][y -1] && grid[x][y - 1] == '1'){
                    deque.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{ {'1','1','1','1','0'}, {'1','1','0','1','0',},
                {'1','1','0','0','0',}, {'0','0','0','0','0'} }));

        System.out.println(numIslands.numIslands(new char[][]{ {'1','1','0','0','0'}, {'1','1','0','0','0',},
                {'0','0','1','0','0',}, {'0','0','0','1','1'} }));
    }
}
