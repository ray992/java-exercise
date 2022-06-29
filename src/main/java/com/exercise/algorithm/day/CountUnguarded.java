package com.exercise.algorithm.day;

/**
 * @ClassName CountUnguarded
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/30 下午11:29
 * @Version 1.0
 **/
public class CountUnguarded {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] used = new int[m][n];
        for (int i = 0; i < walls.length; i++){
            int[] wall = walls[i];
            used[wall[0]][wall[1]] = 2;
        }
        for (int i = 0; i < guards.length; i++){
            int[] guard = guards[i];
            used[guard[0]][guard[1]] = 1;
        }
        for (int i = 0; i < guards.length; i++){
            int[] guard = guards[i];
            int row = guard[0];
            int col = guard[1];
            for (int t = col+1; t < n; t++){
                int cur = used[row][t];
                if (cur == 0){
                    used[row][t] =1;
                    continue;
                }
                if (cur == 2){
                    break;
                }
            }
            for (int t = col-1; t >= 0; t--){
                int cur = used[row][t];
                if (cur == 0){
                    used[row][t] =1;
                    continue;
                }
                if (cur == 2){
                    break;
                }
            }
            for (int r = row+1; r < m; r++){
                int cur = used[r][col];
                if (cur == 0){
                    used[r][col] = 1;
                }
                if (cur == 2){
                    break;
                }
            }
            for (int r = row -1; r >= 0; r--){
                int cur = used[r][col];
                if (cur == 0){
                    used[r][col] = 1;
                }
                if (cur == 2){
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < used.length; i++){
            for (int j = 0; j < used[i].length; j++){
                if (used[i][j] == 0){
                    sum ++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        CountUnguarded countUnguarded = new CountUnguarded();
        System.out.println(countUnguarded.countUnguarded(4, 6, new int[][]{{0,0}, {1,1}, {2,3} }, new int[][]{{0,1}, {2,2}, {1,4} }));
        System.out.println(countUnguarded.countUnguarded(3, 3, new int[][]{ {1,1}}, new int[][]{{0,1},{1,0},  {2,1}, {1,2} }));
    }
}
