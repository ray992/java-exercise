package com.exercise.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyStack
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/29 下午9:27
 * @Version 1.0
 **/
public class MyStack {

    private Deque<Integer> q1 = new LinkedList<>();
    private Deque<Integer> q2 = new LinkedList();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
       q1.addLast(x);
       //q1.pollFirst()
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = q1.isEmpty()?-1:q1.pollLast();
        q1.addLast(x);
        return x;
    }

    /** Get the top element. */
    public int top() {
        return q1.isEmpty()?-1:q1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
