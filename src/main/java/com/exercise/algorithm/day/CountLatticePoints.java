package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountLatticePoints
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/24 10:42 AM
 * @Version 1.0
 **/
public class CountLatticePoints {

    public int countLatticePoints(int[][] circles) {
        boolean[][] used = new boolean[10000][10000];
        List<int[]> circleList = new ArrayList<>();
        for (int i = 0; i < circles.length; i++){
            circleList.add(new int[]{circles[i][0] - circles[i][2],
                    circles[i][0] + circles[i][2],
                    circles[i][1] - circles[i][2],
                    circles[i][1] + circles[i][2], circles[i][0], circles[i][1], circles[i][2]});
        }
        int total = 0;
        for (int[] aa:circleList){
            int l = aa[0];
            int r = aa[1];
            int d = aa[2];
            int u = aa[3];
            int x = aa[4];
            int y = aa[5];
            int rr = aa[6];
            for (int i = l; i <= r; i++){
                for (int t = d; t <= u; t++){
                    if (used[i][t]){
                        continue;
                    }
                    if ((i == l && (t != y)) || (i == r && (t != y))){
                        continue;
                    }
                    if ((t == u && i != x) || (t == d && i != x)){
                        continue;
                    }
                    if ( (i - x)*(i -x) + (t - y)* (t - y) - rr*rr > 0 ){
                        continue;
                    }
                    total++;
                    used[i][t] = true;
                }
            }
        }
        return total;

    }

    public static void main(String[] args) {
        CountLatticePoints countLatticePoints = new CountLatticePoints();
        System.out.println(countLatticePoints.countLatticePoints(new int[][]{{2,2,2}, {3,4,1}}));
        System.out.println(countLatticePoints.countLatticePoints(new int[][]{{2,2,1}}));
        System.out.println(countLatticePoints.countLatticePoints(new int[][]{{8,9,6}, {9,8,4}, {4,1,1}, {8,5,1}, {7,1,1},{6,7,5}, {7,1,1}, {7,1,1},{5,5,3}}));
        System.out.println(countLatticePoints.countLatticePoints(new int[][]{{8,9,6}, {9,8,4}, {4,1,1}, {8,5,1}, {7,1,1},{6,7,5},{5,5,3}}));
    }
}
