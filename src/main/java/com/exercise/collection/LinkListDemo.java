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
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.removeLast();
        for (String s:linkedList){
            System.out.println(s);
        }
    }
}
