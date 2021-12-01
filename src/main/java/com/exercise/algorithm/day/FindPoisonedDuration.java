package com.exercise.algorithm.day;

/**
 * @ClassName FindPoisonedDuration
 * @Description 提莫攻击
 * @Author yeqiang
 * @Date 2021/11/10 下午1:44
 * @Version 1.0
 **/
public class FindPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPoisonedDuration findPoisonedDuration = new FindPoisonedDuration();
        //System.out.println(findPoisonedDuration.findPoisonedDuration(new int[]{1,4}, 2));
        //System.out.println(findPoisonedDuration.findPoisonedDuration(new int[]{1,2}, 2));
        System.out.println(findPoisonedDuration.findPoisonedDuration(new int[]{1,2,3,4,5}, 5));
    }
}
