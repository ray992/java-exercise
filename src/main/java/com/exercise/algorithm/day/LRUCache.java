package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/5 下午10:37
 * @Version 1.0
 **/
public class LRUCache {

    Map<Integer, Integer> dataMap = new HashMap<>();

    Deque<Integer> useQueue = new LinkedList<>();

    int capacity = 0;

    int cacheSize = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (useQueue.contains(key)){
            useQueue.remove(key);
        }
        if(dataMap.containsKey(key) && !useQueue.contains(key)){
            useQueue.addLast(key);
        }
        return dataMap.get(key) == null ? -1:dataMap.get(key);
    }

    public void put(int key, int value) {
        if (cacheSize >= capacity){
            useQueue.pollFirst();
        }
        if (!dataMap.containsKey(key)){
            cacheSize++;
        }
        if (!useQueue.contains(key)){
            useQueue.addLast(key);
        }
        dataMap.put(key, value);

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println( lruCache.get(2));
        lruCache.put(2, 6);
        System.out.println( lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
