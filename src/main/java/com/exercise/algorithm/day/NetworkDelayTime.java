package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName NetworkDelayTime
 * @Description 网络延迟时间
 * @Author yeqiang
 * @Date 2021/8/2 上午9:13
 * @Version 1.0
 **/
public class NetworkDelayTime {

    List<List<int[]>> edges = new ArrayList<>();
    int[] path;     // 路径长度

    public int networkDelayTime(int[][] times, int N, int K) {
        // 0不使用，实际范围是1~N
        path = new int[N + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        // 初始化边
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        // 添加所有的边
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int dst = times[i][1];
            int value = times[i][2];
            edges.get(src).add(new int[] {dst, value});
        }

        dfs(K, 0);
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, path[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // src源点，t是在t时间到达源点
    public void dfs(int src, int t) {
        if (path[src] > t) {
            path[src] = t;
            for (int[] edge : edges.get(src)) {
                int dst = edge[0];
                int value = edge[1];
                dfs(dst, t + value);
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array, Integer.MAX_VALUE);
        for (int val:array){
            System.out.println(val);
        }
    }
}
