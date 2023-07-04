package com.exercise.algorithm.day;

/**
 * @ClassName NumSpecial
 * @Description 二进制矩阵中的特殊为主
 * @Author yeqiang
 * @Date 2022/9/4 09:27
 * @Version 1.0
 **/
public class NumSpecial {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < m; i++){
            int p = 0;
            int posI = 0;
            int posJ = 0;
            boolean hit = false;
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 1) {
                    posI = i;
                    posJ = j;
                    p++;
                    hit = true;
                }
                if (p > 1){
                    hit = false;
                    break;
                }
            }
            if (hit){
                boolean hit1 = true;
                for (int t = 0; t < m; t++){
                    if (t == posI){
                        continue;
                    }
                    if (mat[t][posJ] == 1){
                        hit1 =false;
                        break;
                    }
                }
                if (hit1){
                    count ++;
                }
            }
        }
        return count;
    }
}
