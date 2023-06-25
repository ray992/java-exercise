package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++){
            deque.push(pushed[i]);
            while (!deque.isEmpty() && deque.peek() == popped[j]){
                deque.pop();
                j ++;
            }
        }
        return deque.isEmpty();
    }
}
