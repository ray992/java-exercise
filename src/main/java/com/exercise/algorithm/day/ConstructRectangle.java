package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName ConstructRectangle
 * @Description 构造矩形
 * @Author yeqiang
 * @Date 2021/10/23 上午9:49
 * @Version 1.0
 **/
public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int diff = 10000000;
        int l = 0 , w = 0;
        int mod, a, b;
        for (int i = 1; i <= Math.abs(Math.sqrt(area)); i++){
            mod = area % i;
            if (mod > 0){
                continue;
            }
            a = i;
            b = area / i;
            if (Math.abs(b-a) < diff){
                diff = Math.abs(b-a);
                if (a <= b){
                    w = a;
                    l = b;
                }else {
                    w = b;
                    l = a;
                }
            }
        }
        return new int[]{l, w};
    }

    public static void main(String[] args) {
        ConstructRectangle constructRectangle = new ConstructRectangle();
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(3)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(1)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(6)));
        System.out.println(Arrays.toString(constructRectangle.constructRectangle(10000000)));
    }
}
