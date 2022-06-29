package com.exercise.algorithm.day;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName CanIWin
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/22 10:11 PM
 * @Version 1.0
 **/
public class CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        PriorityQueue<Integer> chooseNumber = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 1; i <= maxChoosableInteger; i++){
            chooseNumber.offer(i);
        }
        int sum = -1;
        int change = 0;
        int pre = 0;
        int behind = 0;
        while (sum < desiredTotal && !chooseNumber.isEmpty()){
            if ((change & 1) == 0){
                pre++;
            }else {
                behind++;
            }
            sum += chooseNumber.poll();
            change++;
        }
        return pre > behind;
    }

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10, 11));
        System.out.println(canIWin.canIWin(10, 0));
        System.out.println(canIWin.canIWin(10, 1));
        System.out.println(canIWin.canIWin(4, 6));
    }
}

