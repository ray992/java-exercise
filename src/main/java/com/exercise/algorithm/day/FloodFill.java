package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName FloodFill
 * @Description 图像渲染
 * @Author yeqiang
 * @Date 2022/7/7 10:32 AM
 * @Version 1.0
 **/
public class FloodFill {
    class Position {
        int sr;
        int sc;
        int color;

        public Position(int sr, int sc, int color) {
            this.sr = sr;
            this.sc = sc;
            this.color = color;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int r = 0; r < n; r++){
                res[i][r] = image[i][r];
            }
        }
        boolean[][] visited = new boolean[m][n];
        int originColor = image[sr][sc];
        Deque<Position> deque = new ArrayDeque<>();
        deque.offer(new Position(sr, sc, color));
        visited[sr][sc] = true;
        while (!deque.isEmpty()){
            Position p = deque.poll();
            if (image[p.sr][p.sc] != originColor){
                continue;
            }
            res[p.sr][p.sc] = p.color;
            if (p.sr - 1 >= 0 && !visited[p.sr - 1][p.sc]){
                deque.offer(new Position(p.sr - 1, p.sc, p.color));
                visited[p.sr - 1][p.sc] = true;
            }
            if (p.sr + 1 < m && !visited[p.sr + 1][p.sc]){
                deque.offer(new Position(p.sr +1, p.sc, p.color));
                visited[p.sr + 1][p.sc] = true;
            }
            if (p.sc - 1 >= 0 && !visited[p.sr][p.sc - 1]){
                deque.offer(new Position(p.sr, p.sc - 1, p.color));
                visited[p.sr][p.sc - 1] = true;
            }
            if (p.sc + 1 < n && !visited[p.sr][p.sc + 1]){
                deque.offer(new Position(p.sr, p.sc + 1, p.color));
                visited[p.sr][p.sc + 1] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        System.out.println(Arrays.deepToString(floodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2)));
    }
}
