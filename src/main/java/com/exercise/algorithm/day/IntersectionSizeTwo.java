package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName IntersectionSizeTwo
 * @Description 设置交集大小至少为2
 * @Author yeqiang
 * @Date 2022/7/22 8:20 AM
 * @Version 1.0
 **/
public class IntersectionSizeTwo {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            int tempStart = Math.max(curStart, start);
            int tempEnd = Math.min(curEnd, end);
            if (tempEnd - tempStart + 1 > 2){

            }
        }
        //todo
        return 0;
    }
}
