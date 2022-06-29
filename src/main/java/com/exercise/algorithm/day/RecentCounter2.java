package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName RecentCounter2
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/6 9:31 AM
 * @Version 1.0
 **/
public class RecentCounter2 {

    Deque<Integer> counterDeque;

    public RecentCounter2() {
        counterDeque = new ArrayDeque<>();
    }

    public int ping(int t) {
        counterDeque.addLast(t);
        while (!counterDeque.isEmpty()){
            int peek = counterDeque.peekFirst();
            if (peek < t - 3000){
                counterDeque.pollFirst();
            }else {
                break;
            }
        }
        return counterDeque.size();
    }
}
