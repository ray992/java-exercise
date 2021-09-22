package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description 最小栈
 * @Author yeqiang
 * @Date 2021/9/9 下午10:35
 * @Version 1.0
 **/
public class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    PriorityQueue<Integer> minDeque = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        minDeque.add(x);
    }

    public void pop() {
        int x = stack.pop();
        minDeque.remove(x);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minDeque.element();
    }
}
