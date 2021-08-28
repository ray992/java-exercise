package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindCheapestPrice
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/24 上午9:06
 * @Version 1.0
 **/
public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //构建图 u->v w
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});//0 表示当前点，1表示的是到达当前点的距离dist
        int ans = Integer.MAX_VALUE;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int u = curr[0], dist = curr[1];
                if (u == dst) ans = Math.min(ans, dist);//找到目的地站
                if (graph.containsKey(u)) {
                    for (int[] next : graph.get(u)) {
                        if (dist + next[1] > ans) continue;//松弛
                        q.offer(new int[]{next[0], dist + next[1]});
                    }
                }
            }
            //先比较level 与K 再执行++ 的，bfs的层数，类似水波纹的一圈一圈的，一层表示经过一个站
            if (level++ > k) break;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }



}
