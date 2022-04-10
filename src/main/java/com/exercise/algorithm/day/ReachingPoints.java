package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName ReachingPoints
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/9 5:33 PM
 * @Version 1.0
 **/
public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            for (int i = 0; i < size; i++){
                int[] curPosition = queue.poll();
                int x = curPosition[0];
                int y = curPosition[1];
                if (x == tx && y == ty){
                    return true;
                }
                int newX = 0;
                int newY = 0;
                if (x < tx){
                    newX = x + y;
                    if (newX <= tx){
                        queue.offer(new int[]{newX, y});
                    }
                }
                if (y < ty){
                    newY = y + x;
                    if (newY <= ty){
                        queue.offer(new int[]{x, newY});
                    }
                }
            }
        }
        return false;
    }

    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy){
            return false;
        }
        if (sx == tx){
            return (ty - sy) % sx == 0;
        }
        if (sy == ty){
            return (tx - sx) % sy == 0;
        }
        return (tx > ty )?(reachingPoints2(sx, sy, tx-ty, ty)):(reachingPoints2(sx, sy, tx, ty-tx));
     }

    public static void main(String[] args) {
        ReachingPoints reachingPoints = new ReachingPoints();
        System.out.println(reachingPoints.reachingPoints2(1, 1, 3, 5));
        System.out.println(reachingPoints.reachingPoints2(1, 1, 2, 2));
        System.out.println(reachingPoints.reachingPoints2(1, 1, 1, 1));
        System.out.println(reachingPoints.reachingPoints2(35, 13, 455955547, 420098884));
    }
}
