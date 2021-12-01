package com.exercise.concurrent;

/**
 * @ClassName IncreaseDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/11/1 下午10:26
 * @Version 1.0
 **/
public class IncreaseDemo {

    public static void main(String[] args) {
        int i = 0;
        //System.out.println(++(i++)); //编译不通过
        //System.out.println(i);
        i = (++i) + (i++) + (++i) + (++i);
        System.out.println(i);
    }
}
