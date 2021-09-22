package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName CorpFlightBookings
 * @Description 航班预订统计
 * @Author yeqiang
 * @Date 2021/8/31 上午9:51
 * @Version 1.0
 **/
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < bookings.length; i++){
            int first  = bookings[i][0];
            int last = bookings[i][1];
            int seat = bookings[i][2];
            while (first <= last){
                answer[first-1]+=seat;
                first++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        System.out.println(Arrays.toString(corpFlightBookings.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
        System.out.println(Arrays.toString(corpFlightBookings.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)));
    }
}


