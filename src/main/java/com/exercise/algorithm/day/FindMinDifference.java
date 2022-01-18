package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName FindMinDifference
 * @Description 最小时间差
 * @Author yeqiang
 * @Date 2022/1/18 上午9:52
 * @Version 1.0
 **/
public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] oA1 = o1.split("[:]");
                String[] oA2 = o2.split("[:]");
                int h1 = Integer.parseInt(oA1[0].startsWith("0") ? oA1[0].substring(1) : oA1[0]);
                int h2 = Integer.parseInt(oA2[0].startsWith("0") ? oA2[0].substring(1) : oA2[0]);
                if (h1 == h2) {
                    int m1 = Integer.parseInt(oA1[1].startsWith("0") ? oA1[1].substring(1) : oA1[1]);
                    int m2 = Integer.parseInt(oA2[1].startsWith("0") ? oA2[1].substring(1) : oA2[1]);
                    return m1 - m2;
                }
                return h1 - h2;
            }
        });
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++){
            String curTime = timePoints.get(i);
            String nextTime = timePoints.get(i+1);
            String[] oA1 = curTime.split("[:]");
            String[] oA2 = nextTime.split("[:]");
            int h1 = Integer.parseInt(oA1[0].startsWith("0") ? oA1[0].substring(1) : oA1[0]);
            int h2 = Integer.parseInt(oA2[0].startsWith("0") ? oA2[0].substring(1) : oA2[0]);
            int m1 = Integer.parseInt(oA1[1].startsWith("0") ? oA1[1].substring(1) : oA1[1]);
            int m2 = Integer.parseInt(oA2[1].startsWith("0") ? oA2[1].substring(1) : oA2[1]);
            if (m2 < m1){
                m2 = m2 + 60;
                h2 = h2 -1;
            }
            int diff = (h2 - h1)*60+(m2 - m1);
            if (diff < min){
                min = diff;
            }
        }
        String[] oA1 = timePoints.get(0).split("[:]"); //最小
        String[] oA2 = timePoints.get(timePoints.size() - 1).split("[:]"); //最大
        int h1 = Integer.parseInt(oA1[0].startsWith("0") ? oA1[0].substring(1) : oA1[0]) + 24;
        int h2 = Integer.parseInt(oA2[0].startsWith("0") ? oA2[0].substring(1) : oA2[0]);
        int m1 = Integer.parseInt(oA1[1].startsWith("0") ? oA1[1].substring(1) : oA1[1]);
        int m2 = Integer.parseInt(oA2[1].startsWith("0") ? oA2[1].substring(1) : oA2[1]);
        if (m1 < m2){
            m1 = m1 + 60;
            h1 = h1 -1;
        }
        int diff = (h1 - h2)*60 + (m1 - m2);
        if (diff < min){
            min = diff;
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        //timePoints.add("00:01");
        timePoints.add("00:00");
        timePoints.add("23:59");
        FindMinDifference findMinDifference = new FindMinDifference();
        System.out.println(findMinDifference.findMinDifference(timePoints));
    }
}
