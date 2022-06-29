package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProjectionArea
 * @Description 三维形体投影面积
 * @Author yeqiang
 * @Date 2022/4/26 1:15 PM
 * @Version 1.0
 **/
public class ProjectionArea {

    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int xz = 0;
        int yz = 0;
        int xy = 0;
        Map<Integer, Integer> yzMap = new HashMap<>();
        for (int i = 0; i < len; i++){
            //xz
            int curXZ = Integer.MIN_VALUE;
            for (int j = 0; j < grid[i].length; j++){
                if (curXZ < grid[i][j]){
                    curXZ = grid[i][j];
                }
                //xy
                if (grid[i][j] > 0){
                    xy++;
                }
               Integer curYZ = yzMap.getOrDefault(j, 0);
               if (curYZ < grid[i][j]){
                   curYZ = grid[i][j];
                   yzMap.put(j, curYZ);
               }
            }
            xz += curXZ;
        }
        for (Map.Entry<Integer, Integer> map:yzMap.entrySet()){
            yz += map.getValue();
        }
        return xz + yz + xy;
    }

    public static void main(String[] args) {
        ProjectionArea projectionArea = new ProjectionArea();
        System.out.println(projectionArea.projectionArea(new int[][]{{1,2}, {3,4} }));
        System.out.println(projectionArea.projectionArea(new int[][]{{2} }));
        System.out.println(projectionArea.projectionArea(new int[][]{{1,0}, {0,2} }));
    }
}
