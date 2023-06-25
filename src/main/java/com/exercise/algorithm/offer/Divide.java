package com.exercise.algorithm.offer;


import org.apache.commons.lang.time.StopWatch;

public class Divide {

    public int divide(int a, int b) {
       return 0;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
       /* System.out.println(-6 /2);
        System.out.println(-6 / -2);
        System.out.println(5/3);
        System.out.println(5/-3);*/
        Divide divide = new Divide();
    /*    System.out.println(divide.divide(-6, 2));
        System.out.println(divide.divide(-6, -2));
        System.out.println(divide.divide(5, 3));
        System.out.println(divide.divide(5, -3));*/
        System.out.println(divide.divide(15,2));
        System.out.println(divide.divide(7,-3));
        System.out.println(divide.divide(0, 1));
        System.out.println(divide.divide(1,1));
    }
}
