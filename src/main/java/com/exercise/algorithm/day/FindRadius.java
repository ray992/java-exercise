package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindRadius
 * @Description 供暖器
 * @Author yeqiang
 * @Date 2021/12/20 下午9:36
 * @Version 1.0
 **/
public class FindRadius {

    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        for(int i=0; i<houses.length; ++i) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<heaters.length; ++j) {
                // 极小化
                min = Math.min(min,Math.abs(houses[i]-heaters[j]));
            }
            // 极小化极大
            res = Math.max(res,min);
        }

        return res;
    }

    public static void main(String[] args) {
        FindRadius findRadius = new FindRadius();
        System.out.println(findRadius.findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println(findRadius.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        System.out.println(findRadius.findRadius(new int[]{1,5}, new int[]{2}));
    }
}
