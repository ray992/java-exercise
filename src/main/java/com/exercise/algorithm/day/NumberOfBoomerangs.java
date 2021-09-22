package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumberOfBoomerangs
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/13 上午9:45
 * @Version 1.0
 **/
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int pointLength = points.length;
        boolean[][][] visited = new boolean[pointLength][pointLength][pointLength];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < pointLength; i++){
            for (int j = 0; j < pointLength; j++){
                for (int k = 0; k < pointLength; k++){
                    if (i == j || i == k || j == k){
                        continue;
                    }
                    if (visited[i][j][k]){
                        continue;
                    }
                    int x1 = Math.abs(points[i][0] - points[j][0]);
                    int y1 = Math.abs(points[i][1] - points[j][1]);
                    int x2 = Math.abs(points[i][0] - points[k][0]);
                    int y2 = Math.abs(points[i][1] - points[k][1]);
                    if ((x1*x1 + y1*y1) == (x2*x2+y2*y2)){
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < visited.length;i++){
            for (int j = 0; j < visited[i].length; j++){
                for (int k = 0; k < visited[i][j].length; k++){
                    if (visited[i][j][k]){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(new int[][]{{1,1}}));
    }
}
