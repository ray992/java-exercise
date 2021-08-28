package com.exercise.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName LastRemaining
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午6:59
 * @Version 1.0
 **/
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        if (n == 1){
            return n;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++){
            deque.addLast(i);
        }
        int i = 0;
        while (!deque.isEmpty()){
            if (deque.size() == 1){
                break;
            }
            int val = deque.pollFirst();
            i ++;
            if (i == m){
                i = 0;
                continue;
            }
            deque.addLast(val);
        }
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        int onlyOne = lastRemaining.lastRemaining(10, 17);
        System.out.println(onlyOne);
    }
}
