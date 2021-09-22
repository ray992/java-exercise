package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName TripleInOne
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/9 下午11:29
 * @Version 1.0
 **/
public class TripleInOne {

    private int[] data = null;
    private int index = 0;

    public TripleInOne(int stackSize) {
        data = new int[stackSize];
        Arrays.fill(data, -1);
    }

    public void push(int stackNum, int value) {
        data[index] = value;
        if(index+1 > data.length - 1){
            return;
        }
        index++;
    }

    public int pop(int stackNum) {
        if (index == 0){
            return -1;
        }
        return data[--index];
    }

    public int peek(int stackNum) {
        return data[index];
    }

    public boolean isEmpty(int stackNum) {
        return index > 0;
    }
}
