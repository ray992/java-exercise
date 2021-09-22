package com.exercise.collection;

import java.util.WeakHashMap;

/**
 * @ClassName WeakHashMapDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/28 下午4:40
 * @Version 1.0
 **/
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put("a", 1);
        System.out.println(weakHashMap.isEmpty());
        System.out.println(weakHashMap.isEmpty());
        System.out.println(weakHashMap.size());
        System.out.println(weakHashMap.size());
    }
}
