package com.exercise.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName ArrayListDemo
 * @Description ArrayList 遍历测试
 * @Author yeqiang
 * @Date 2020/10/9 8:54 上午
 * @Version 1.0
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
       /* for (int i = 0; i < 100000; i ++){
            list.add(i);
        }
        randomAccess(list);
        iteratorAccess(list);
        forAccess(list);
        //Java不支持向下转型
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        String[] array = stringList.toArray(new String[0]);
        String[] array2= new String[stringList.size()];
        stringList.toArray(array2);
        System.out.println(array.length);
        System.out.println(array2.length);*/
        list.add(1);
        list.add(2);
        System.out.println(list.toString());
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        System.out.println(list.size());
        System.out.println(list.toString());
        for (Integer integer:list){
            System.out.println(integer);
        }
        list.trimToSize();
    }

    /**
    * @Name randomAccess
    * @Description 随机访问
    * @Date 2020/10/9 8:57 上午
    * @params [list]
    * @return void
    **/
    public static void randomAccess(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++){
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("randomAccessTime: "+(endTime-startTime));
    }

    /**
    * @Name iteratorAccess
    * @Description 迭代器访问
    * @Date 2020/10/9 8:58 上午
    * @params [list]
    * @return void
    **/
    public static void iteratorAccess(List list){
        long startTime = System.currentTimeMillis();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()){
            listIterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorAccess: "+(endTime-startTime));
    }

    /**
    * @Name forAccess
    * @Description for循环访问
    * @Date 2020/10/9 8:59 上午
    * @params [list]
    * @return void
    **/
    public static void forAccess(List list){
        long startTime = System.currentTimeMillis();
        for (Object o:list){

        }
        long endTime = System.currentTimeMillis();
        System.out.println("forAccess: "+(endTime-startTime));
    }
}
