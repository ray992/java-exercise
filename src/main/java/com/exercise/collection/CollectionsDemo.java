package com.exercise.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName CollectionsDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/9/21 22:31
 * @Version 1.0
 **/
public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(i);
        }
        int index = Collections.binarySearch(list, 3);
        System.out.println(index);

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list2.add(i);
        }
        // 洗牌算法
        Collections.shuffle(list2);
        System.out.println(list2);
        // 旋转算法
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list3.add(i);
        }
        Collections.rotate(list3, 5);
        System.out.println(list3);

    }
}
