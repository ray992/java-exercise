package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName MinEatingSpeed
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/7 11:19 PM
 * @Version 1.0
 **/
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        while (low < high){
            int speed = (high - low) / 2 + low;
            int sumHour = 0;
            for (int i = 0; i < piles.length; i++){
                sumHour += (piles[i] + speed - 1)/ speed;
            }
            if (sumHour <= h){
                high = speed;
            }else {
                low = speed + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
    }
}
