package com.exercise.algorithm.day;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName LastRemaining
 * @Description 消除游戏
 * @Author yeqiang
 * @Date 2022/1/4 上午10:02
 * @Version 1.0
 **/
public class LastRemaining {

    public int lastRemaining(int n) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            deque1.offerLast(i);
        }

        return 0;
    }
}
