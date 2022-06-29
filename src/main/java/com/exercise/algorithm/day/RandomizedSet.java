package com.exercise.algorithm.day;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RandomizedSet
 * @Description O(1) 时间插入，删除和随机获取元素
 * @Author yeqiang
 * @Date 2022/4/13 9:38 AM
 * @Version 1.0
 **/
public class RandomizedSet {

    List<Integer> dataList;
    Set<Integer> compareSet;
    int size = 0;
    Random random = new Random();

    public RandomizedSet() {
        dataList = new ArrayList<>();
        compareSet = new HashSet<>();
    }

    public boolean insert(int val) {
        if (compareSet.add(val)){
            dataList.add(val);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (compareSet.remove(val)){
            dataList.remove(new Integer(val));
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        int index = random.nextInt(size);
        return dataList.get(index);
    }

    public static void main(String[] args) throws InterruptedException {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        for (int i = 0; i <1024 ; i++) {
            ByteBuffer.allocateDirect(1024*1024);
            System.out.println(i);
//            System.gc();
        }
        TimeUnit.SECONDS.sleep(60);
    }
}
