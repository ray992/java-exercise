package com.exercise.algorithm;

/**
 * @ClassName MaximumCandies
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/4 11:01 AM
 * @Version 1.0
 **/
public class MaximumCandies {

    public int maximumCandies(int[] candies, long k) {
        long l = 0;
        long r = (long)1e7;
        while (l < r){
            long mid = (l + r + 1) / 2;
            long cnt = 0;
            for (int i:candies){
                cnt += i / mid;
            }
            if (cnt < k){
                r = mid - 1;
            }else {
                l = mid;
            }
        }
        return (int)l;
    }

    public static void main(String[] args) {
        MaximumCandies maximumCandies = new MaximumCandies();
        System.out.println(maximumCandies.maximumCandies(new int[]{5, 8, 6}, 3));
    }
}
