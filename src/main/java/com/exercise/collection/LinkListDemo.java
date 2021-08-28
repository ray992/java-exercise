package com.exercise.collection;

import java.util.LinkedList;

/**
 * @ClassName LinkListDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/23 下午8:29
 * @Version 1.0
 **/
public class LinkListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.remove("a"));
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
    }
}
