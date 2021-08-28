package com.exercise.algorithm;

import java.util.Stack;

/**
 * @ClassName CQueue
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/30 下午10:49
 * @Version 1.0
 **/
public class CQueue {

    public Stack<Integer> stack1 = new Stack<>();

    public Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            return -1;
        }
        int removeElement = -1;
        while (!stack1.isEmpty()){
            if (stack1.size() == 1){
                removeElement = stack1.pop();
                break;
            }
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return removeElement;
    }
}
