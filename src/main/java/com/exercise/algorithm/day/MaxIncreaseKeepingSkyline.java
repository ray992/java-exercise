package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaxIncreaseKeepingSkyline
 * @Description 保持城市天际线
 * @Author yeqiang
 * @Date 2021/12/13 上午9:56
 * @Version 1.0
 **/
public class MaxIncreaseKeepingSkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] upright = new int[rowLength]; //竖直方向
        int[] horizontal = new int[colLength]; //水平放行
        int perRowMax = -1;
        Map<Integer, Integer> perColMaxMap = new HashMap<>();
        for (int i = 0; i < rowLength; i++){
            for (int j = 0; j < colLength; j++){
                int cur = grid[i][j];
                if (cur > perRowMax){
                    perRowMax = grid[i][j];
                }
                if (cur >perColMaxMap.getOrDefault(j, -1)){
                    perColMaxMap.put(j, cur);
                }
                if (i == rowLength - 1){
                    upright[j] = perColMaxMap.get(j);
                }
                if (j == colLength - 1){
                    horizontal[i] = perRowMax;
                    perRowMax = -1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < rowLength; i++){
            for (int j = 0; j <colLength; j++){
                int extra = Math.min(horizontal[i], upright[j]);
                sum += extra - grid[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxIncreaseKeepingSkyline maxIncreaseKeepingSkyline = new MaxIncreaseKeepingSkyline();
        //int result = maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
        //System.out.println(result);
        int result2 = maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(new int[][]{{0,0,0},{0,0,0},{0,0,0}});
        System.out.println(result2);
    }
}
