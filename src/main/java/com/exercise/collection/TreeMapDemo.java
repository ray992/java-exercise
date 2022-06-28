package com.exercise.collection;

import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(2, 1);
        treeMap.put(3, 2);
        treeMap.put(1, 3);
        treeMap.put(0, 4);
        treeMap.ceilingEntry(1);

        System.out.println(treeMap.ceilingKey(1));
        System.out.println(treeMap.floorKey(4));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.lowerKey(1));
        System.out.println(treeMap.higherKey(2));

        NavigableMap<Integer, Integer> navigableMap = treeMap.descendingMap();
        System.out.println(navigableMap);

    }
}
