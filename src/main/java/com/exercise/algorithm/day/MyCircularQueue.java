package com.exercise.algorithm.day;

import java.util.Deque;
import java.util.LinkedList;

// 设计循环队列
public class MyCircularQueue {

    int capacity = 0;
    int size = 0;
    Deque<Integer> queue;

    public MyCircularQueue(int k) {
        this.capacity = k;
        queue = new LinkedList<>();
    }

    public boolean enQueue(int value) {
        if (this.size >= this.capacity){
            return false;
        }
        this.size++;
        queue.offerLast(value);
        return true;
    }

    public boolean deQueue() {
        if (this.size == 0){
            return false;
        }
        this.size--;
        queue.pollFirst();
        return true;
    }

    public int Front() {
        if (this.size == 0){
            return -1;
        }
        return queue.peekFirst();
    }

    public int Rear() {
        if (this.size == 0){
            return -1;
        }
        return queue.peekLast();
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public boolean isFull() {
        return this.size >= this.capacity;
    }
}
