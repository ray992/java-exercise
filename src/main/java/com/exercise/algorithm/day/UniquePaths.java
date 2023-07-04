package com.exercise.algorithm.day;

/**
 * @ClassName UniquePaths
 * @Description 不同路径
 * @Author yeqiang
 * @Date 2022/7/7 5:54 PM
 * @Version 1.0
 **/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] pos = new int[m][n];
        for (int i = 0; i < n; i++){
            pos[0][i] = 1;
        }
        for (int j = 0; j < m ; j++){
            pos[j][0] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                pos[i][j] = pos[i -1][j] + pos[i][j -1];
            }
        }
        return pos[m - 1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }

}
