package com.exercise.algorithm;

/**
 * @ClassName ClassLoaderDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/7 下午8:47
 * @Version 1.0
 **/
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader.getParent());
        System.out.println(classLoader);
    }
}
