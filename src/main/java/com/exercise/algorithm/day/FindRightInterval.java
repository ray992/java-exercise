package com.exercise.algorithm.day;

import java.util.*;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if (n == 1){
            return new int[]{-1};
        }
        List<Integer> endList = new ArrayList<>();
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (int[] interval:intervals){
            int start = interval[0];
            if (start > max){
                max = start;
            }
            int end = interval[1];
            endList.add(end);
            startIndexMap.put(start, i);
            i++;
        }
        int[] res = new int[n];
        for (int r = 0; r < endList.size(); r ++){
            int curEnd = endList.get(r);
            if (curEnd > max){
                res[r] = -1;
            }else {
                for (int m = curEnd; m <= max; m++){
                    if (startIndexMap.containsKey(m)){
                        res[r] = startIndexMap.get(m);
                        break;
                    }
                }
            }
        }
        return res;
    }

    //二分查找
    public int[] findRightInterval2(int[][] intervals){
        int n = intervals.length;
        int[][] startInterval = new int[n][2];
        for (int i = 0; i < n; i++){
            startInterval[i][0] = intervals[i][0];
            startInterval[i][1] = i;
        }
        Arrays.sort(startInterval, (o1, o2) ->o1[0] - o2[0] );
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int left = 0;
            int right = n -1;
            int target = -1;
            while (left <= right){
                int mid = left + (right - left)/2;
                if (startInterval[mid][0] >= intervals[i][1]){
                    target = startInterval[mid][1];
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        System.out.println(Arrays.toString(findRightInterval.findRightInterval2(new int[][]{{1, 2}})));
        System.out.println(Arrays.toString(findRightInterval.findRightInterval2(new int[][]{{3, 4}, {2,3}, {1,2}})));
        System.out.println(Arrays.toString(findRightInterval.findRightInterval2(new int[][]{{1, 4}, {2,3}, {3, 4}})));
    }
}
