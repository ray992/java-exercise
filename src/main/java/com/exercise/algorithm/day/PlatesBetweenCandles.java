package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 蜡烛之间的盘子
 */
public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            List<Integer> candleList = new ArrayList<>();
            for (int s1 = left; s1 <= right; s1++){
                if (s.charAt(s1) == '|'){
                    candleList.add(s1);
                }
            }
            if (candleList.size() == 0){
                continue;
            }
            int sum = 0;
            for (int j = 0; j  < candleList.size(); j++){
                if (j < candleList.size() - 1){
                    sum+= candleList.get(j+1) -  candleList.get(j) -1;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public int[] platesBetweenCandles2(String s, int[][] queries) {
        int n = s.length();
        //前缀和
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++){
            if (s.charAt(i) == '*'){
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1;i < n; i++){
            if (s.charAt(i) == '|'){
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i-- ){
            if (s.charAt(i) == '|'){
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int x = right[query[0]];
            int y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x > y ? 0:preSum[y] - preSum[x];
        }
        return ans;
    }




    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        System.out.println(Arrays.toString(platesBetweenCandles.platesBetweenCandles2("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
        System.out.println(Arrays.toString(platesBetweenCandles.platesBetweenCandles2("***|**|*****|**||**|*",
                new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15,16}})));
    }
}
