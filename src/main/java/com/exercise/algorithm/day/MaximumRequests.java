package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * 最多可达成的换楼请求数目
 */
public class MaximumRequests {

    public int maximumRequests(int n, int[][] requests) {
        Map<Integer, int[]> statisticMap = new HashMap<>();
        for (int i = 0; i < requests.length; i++){
            int left = requests[i][0]; //离开
            int to = requests[i][1]; //搬入
            if (!statisticMap.containsKey(left)){
                statisticMap.put(left, new int[]{1, 0});
            }else {
                int[] data = statisticMap.get(left);
                data[0] = data[0] +1;
                statisticMap.put(left, data);
            }
            if (!statisticMap.containsKey(to)){
                statisticMap.put(to, new int[]{0, 1});
            }else {
                int[] data = statisticMap.get(to);
                data[1] = data[1] +1;
                statisticMap.put(to, data);
            }
        }
        int req= 0;
        for (Map.Entry<Integer, int[]> map:statisticMap.entrySet()){
            int[] vals = map.getValue();
            req += Math.min(vals[0], vals[1]);
        }
        return req;
    }

    public static void main(String[] args) {
        MaximumRequests maximumRequests = new MaximumRequests();
        //System.out.println(maximumRequests.maximumRequests(3, new int[][]{{0,0}, {1,2}, {2,1} }));
        //System.out.println(maximumRequests.maximumRequests(4, new int[][]{{0,3}, {3,1}, {1,2}, {2,0} }));
        //System.out.println(maximumRequests.maximumRequests(5, new int[][]{{0,1}, {1,0}, {0,1}, {1,2}, {2,0},{3,4} }));
        System.out.println(maximumRequests.maximumRequests(3, new int[][]{{0,0}, {1,1}, {0,0}, {2,0}, {2,2},{1,1}, {2,1},{0,1},{0,1} }));
    }

}
