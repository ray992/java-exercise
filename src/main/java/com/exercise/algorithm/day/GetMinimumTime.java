package com.exercise.algorithm.day;

/**
 * @ClassName GetMinimumTime
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/23 3:03 PM
 * @Version 1.0
 **/
public class GetMinimumTime {

    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int sumCostTime = 0;
        for (int i = 0; i < fruits.length; i++){
            int type = fruits[i][0];
            int num = fruits[i][1];
            if (num <= limit){
                sumCostTime+= time[type];
            }else {
                int curTimes = num % limit == 0 ? num / limit : num / limit + 1;
                sumCostTime+= time[type] * curTimes;
            }
        }
        return sumCostTime;
    }

    public static void main(String[] args) {
        GetMinimumTime getMinimumTime = new GetMinimumTime();
        System.out.println(getMinimumTime.getMinimumTime(new int[]{2,3,2}, new int[][]{{0,2}, {1,4}, {2,1}}, 3));
        System.out.println(getMinimumTime.getMinimumTime(new int[]{1}, new int[][]{{0,3}, {0, 5}}, 2));
    }
}
