package com.exercise.bigdecimal;

import java.math.BigDecimal;

/**
 * @ClassName BigDecimalDemo
 * @Description 大数运算
 * @Author yeqiang
 * @Date 2021/1/18 9:28 下午
 * @Version 1.0
 **/
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("5.2");
        BigDecimal bigDecimal1 = BigDecimal.valueOf(2.1);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(subtract);
        BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
        System.out.println(multiply);
        //2.476190476190476
        BigDecimal divide = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_CEILING); //向正舍入， 2.4762
        System.out.println(divide);
        BigDecimal divide1 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_DOWN); //向零舍入, 2.4761
        System.out.println(divide1);
        BigDecimal divide2 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_FLOOR); //向零舍入, 2.4761
        System.out.println(divide2);
        BigDecimal divide3 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_HALF_DOWN); //按距离舍入
        System.out.println(divide3);
        BigDecimal divide4 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_HALF_UP); //按距离舍入
        System.out.println(divide4);
        BigDecimal divide5 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_HALF_EVEN); //按距离舍入
        System.out.println(divide5);
        BigDecimal divide6 = bigDecimal.divide(bigDecimal1,4, BigDecimal.ROUND_UP); //按距离舍入
        System.out.println(divide6);
    }
}
