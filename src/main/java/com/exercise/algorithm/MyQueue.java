package com.exercise.algorithm;

import java.util.Stack;

/**
 * @ClassName MyQueue
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/5 8:11 下午
 * @Version 1.0
 **/
public class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty() && s2.empty()){
            s1.push(x);
        }
        if (!s1.empty() && s2.empty()){
            s1.push(x);
        }
        if (s1.empty() && !s2.empty()){
            s2.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Integer x = null;
        if (!s1.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
            x = s2.pop();
        }
        if (!s2.empty()){
            while (!s2.empty()){
                s1.push(s2.pop());
            }
            x = s1.pop();
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {
        Integer front = null;
        if (!s1.empty()){
            while (!s1.empty()){
                front = s1.pop();
                s2.push(front);
            }
        }else if (!s1.empty()){
            while (!s2.empty()){
                front = s2.pop();
                s1.push(front);
            }
        }else {
            return front;
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s1.empty() && s2.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
