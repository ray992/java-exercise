package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName OuterTrees
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/23 8:20 AM
 * @Version 1.0
 **/
public class OuterTrees {

    public int[][] outerTrees(int[][] trees) {
        int l = 101 , d = 101;
        int r = -1, u = -1;
        Map<Integer, List<Integer>> xPositionMap = new HashMap<>();
        Map<Integer, List<Integer>> yPositionMap = new HashMap<>();
        for (int i = 0; i < trees.length; i++){
            int[] pos = trees[i];
            if (l > pos[0]){
                l = pos[0];
            }
            if (d > pos[1]){
                d = pos[1];
            }
            if (r < pos[0]){
                r = pos[0];
            }
            if (u < pos[1]){
                u = pos[1];
            }
            List<Integer> yList = xPositionMap.get(pos[0]);
            if (yList != null){
                yList.add(pos[1]);
            }else {
                yList = new ArrayList<>();
                yList.add(pos[1]);
                xPositionMap.put(pos[0], yList);
            }
            List<Integer> xList = yPositionMap.get(pos[1]);
            if (xList != null){
                xList.add(pos[0]);
            }else {
                xList = new ArrayList<>();
                xList.add(pos[0]);
                yPositionMap.put(pos[1], xList);
            }
        }
        List<Integer> lYList = xPositionMap.get(l);
        Collections.sort(lYList);
        int lyu = lYList.get(lYList.size() - 1); // 左顶
        int lyd = lYList.get(0); // 左底
        List<Integer> rYList = xPositionMap.get(r);
        Collections.sort(rYList);
        int ryu = rYList.get(rYList.size() -1); // 右顶
        int ryd = rYList.get(0); //右底
        List<Integer> uXList = yPositionMap.get(u);
        Collections.sort(uXList);
        int uxl = uXList.get(0); // 顶左
        int uxr = uXList.get(uXList.size() - 1); //顶右
        List<Integer> dXList = yPositionMap.get(d);
        Collections.sort(dXList);
        int dxl = dXList.get(0); // 底左
        int dxr = dXList.get(dXList.size() - 1); //底右
        System.out.println("*** 左 ***");
        System.out.println(l + ", " + lyd);
        System.out.println(l + ", " + lyu);
        System.out.println("*** 底 ***");
        System.out.println(dxl + ", " + d);
        System.out.println(dxr + ", " + d);
        System.out.println("*** 右 ***");
        System.out.println(r + ", " + ryd);
        System.out.println(r + ", " + ryu);
        System.out.println("*** 顶 ***");
        System.out.println(uxl + ", " + u);
        System.out.println(uxr + ", " + u);

        List<int[]> matchList = new ArrayList<>();
        for (int i = 0; i < trees.length; i++){
            int x = trees[i][0];
            int y = trees[i][1];
            if (x == l || x == r || y == u || y == d){
                matchList.add(new int[]{x,y});
                continue;
            }
            // 左底 - 底左
            int sum = 0;
            if (x > l && x < dxl && y < lyd && y > d){
                sum = (x*(lyd - d) + l*d - dxl*lyd);
                double curY =  sum % (l - dxl) == 0 ? sum / (l -dxl) :sum / (l -dxl) +0.5;
                if (curY >= y){
                    matchList.add(new int[]{x,y});
                    continue;
                }
            }
            // 底右 - 右底
            if (x > dxr && x < r && y < ryd && y > d){
                sum = (x*(ryd - d) + r*d - dxr*ryd);
                double curY = sum % (r - dxr) == 0 ? sum/(r - dxr):sum/(r - dxr) + 0.5;
                if (curY >= y){
                    matchList.add(new int[]{x,y});
                    continue;
                }
            }
            //左顶 - 顶左
            if (x > l && x < uxl && y > lyu && y < u){
                sum = (x*(lyu - u) + l*u - uxl*lyu);
                double curY = sum % (l - uxl) == 0 ? sum / (l - uxl) : sum / (l - uxl)  + 0.5;
                if (curY <= y){
                    matchList.add(new int[]{x,y});
                    continue;
                }
            }
            // 右顶 - 顶右
            if (x > uxl && x < r && y > ryu && y < u){
                sum = (x*(u - ryu) + uxr*ryu - r*u);
                double curY = sum % (uxr - r) == 0 ? sum / (uxr - r) :sum / (uxr - r) + 0.5;
                if (curY <= y){
                    matchList.add(new int[]{x,y});
                }
            }

        }
        int[][] res = new int[matchList.size()][];

        for (int i = 0;i < matchList.size(); i++){
            res[i] = matchList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        OuterTrees outerTrees = new OuterTrees();
        //System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}})));
        //System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{1, 2}, {2, 2}, {4, 2}})));
        //System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{3, 7}, {6, 8}, {7, 8}, {11,10},{4,3}, {8,5}, {7,13}, {4,13}})));
        //System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{3,0},{4,0},{5,0},{6,1},{7,2},{7,3},{7,4}, {6,5},{5,5},{4,5},{3,5},{2,5},{1,4},{1,3},{1,2},{2,1},{4,2},{0,3}})));
        //System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{8, 8}, {6, 4}, {8, 6}, {0, 5}, {6, 7}, {7, 6}})));
        System.out.println(Arrays.deepToString(outerTrees.outerTrees(new int[][]{{3,3}, {9,3}, {4, 7}, {9,9}, {8,7}, {4,1}, {0,3},{2,7}})));
    }
}
