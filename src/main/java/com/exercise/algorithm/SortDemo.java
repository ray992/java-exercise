package com.exercise.algorithm;

import java.util.*;

/**
 * @ClassName SortDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/1 下午10:58
 * @Version 1.0
 **/
public class SortDemo {

    public void sortCollection(List<Integer> collection, Comparator<Integer> comparator){
        collection.sort(comparator);
        for (Integer val:collection){
            System.out.println(val);
        }
    }

    public void sortArray(int[] array){
        Arrays.sort(array);
        for (int val:array){
            System.out.println(val);
        }
    }


    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(3);
        numList.add(2);
        numList.add(11);
        numList.add(9);
        numList.add(3);
        SortDemo sortDemo = new SortDemo();
        sortDemo.sortCollection(numList, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] array = {2,5,1,10,0,4,1};
        sortDemo.sortArray(array);
    }
}
