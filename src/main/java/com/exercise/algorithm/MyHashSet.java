package com.exercise.algorithm;

import java.util.*;

/**
 * @ClassName MyHashSet
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/13 8:11 下午
 * @Version 1.0
 **/
public class MyHashSet {

    private Deque<Integer> integerDeque = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        boolean isHit = false;
        if (integerDeque.size() == 0){
            integerDeque.push(key);
            return;
        }
        Iterator<Integer> iterator = integerDeque.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(key)){
                isHit = true;
                break;
            }
        }
        if (!isHit){
            integerDeque.push(key);
        }
    }

    public void remove(int key) {
        if (integerDeque.size() == 0){
            return;
        }
        Iterator<Integer> iterator = integerDeque.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(key)){
                iterator.remove();
                break;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (integerDeque.size() == 0){
            return false;
        }
        Iterator<Integer> iterator = integerDeque.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(key)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
