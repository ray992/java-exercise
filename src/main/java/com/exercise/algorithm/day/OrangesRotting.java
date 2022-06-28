package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName OrangesRotting
 * @Description 腐烂的橘子
 * @Author yeqiang
 * @Date 2022/1/29 下午3:03
 * @Version 1.0
 **/
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int res = 0;
        int freshOrange = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    deque.addLast(new int[]{i, j}); //判断腐烂橘子的坐标
                }
                if (grid[i][j] == 1){
                    freshOrange++; //统计新鲜橘子的个数
                }
            }
        }
        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!deque.isEmpty()){
            int curCount  = deque.size();
            boolean mistake = false;
            for (int i = 0; i < curCount; i++){
                int[] cur = deque.pollFirst();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir:dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n){
                        continue; //是否越界
                    }
                    if (grid[nx][ny] == 0 || grid[nx][ny] == 2){
                        continue; //判断是否是空位置和腐烂橘子
                    }
                    mistake = true;
                    grid[nx][ny] = 2;
                    freshOrange--; //新鲜橘子减一
                    deque.addLast(new int[]{nx, ny});
                }
            }
            if (mistake){
                res++;//时间加一
            }
        }
        return (freshOrange == 0 )?res:-1;
    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(new int[][]{{2,1,1}, {1,1,0}, {0,1,1}}));
        System.out.println(orangesRotting.orangesRotting(new int[][]{{2,1,1}, {0,1,1}, {1,0,1}}));
        System.out.println(orangesRotting.orangesRotting(new int[][]{{0,2}}));
    }
}
