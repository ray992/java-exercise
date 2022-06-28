package com.exercise.algorithm.day;

/**
 * @ClassName LeastMinutes
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/9 上午12:08
 * @Version 1.0
 **/
public class LeastMinutes {

    public int leastMinutes(int n) {
       int speed = 1;
       int res = 0;
       while (n > 0){
           if (n <= speed){
               n = n - speed;
               res = res +1;
           }else {
               res = res + 1;
               speed = speed <<1;
           }
       }
       return res;
    }

    public static void main(String[] args) {
        LeastMinutes leastMinutes = new LeastMinutes();
        System.out.println(leastMinutes.leastMinutes(3));
        //System.out.println(leastMinutes.leastMinutes(4));
    }
}
