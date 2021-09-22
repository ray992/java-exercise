package com.exercise.system;

/**
 * @ClassName HeadTest
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/13 上午12:04
 * @Version 1.0
 **/
public class HeadTest {

    public static void main(String[] args) {

        //返回 JVM 堆大小
        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 /1024;
        //返回 JVM 堆的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 /1024;

        System.out.println("-Xms : "+initalMemory + "M");
        System.out.println("-Xmx : "+maxMemory + "M");

        System.out.println("系统内存大小：" + initalMemory * 64 / 1024 + "G");
        System.out.println("系统内存大小：" + maxMemory * 4 / 1024 + "G");
    }
}
