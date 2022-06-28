package com.exercise.collection;

import java.util.LinkedList;

/**
 * @ClassName LinkedListDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/23 下午8:29
 * @Version 1.0
 **/
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.removeLast();
        for (String s:linkedList){
            System.out.println(s);
        }
        System.out.println(linkedList.getFirst()); //获取第一个元素
        System.out.println(linkedList.getLast());; //获取最后一个元素
    }
}
