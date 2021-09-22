package com.exercise.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/5 8:11 下午
 * @Version 1.0
 **/
public class MyQueue {

    private Deque<Integer> s1 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {

    }
}
