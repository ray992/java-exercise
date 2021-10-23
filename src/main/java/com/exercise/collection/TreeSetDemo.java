package com.exercise.collection;

import java.util.TreeSet;

/**
 * @ClassName TreeSetDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/6 下午12:01
 * @Version 1.0
 **/
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(2);
        treeSet.add(11);
        System.out.println(treeSet.first());
        System.out.println(treeSet.floor(9));
    }
}
