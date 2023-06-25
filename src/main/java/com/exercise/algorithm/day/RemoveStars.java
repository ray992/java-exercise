package com.exercise.algorithm.day;


import java.util.*;

public class RemoveStars {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c == '*'){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public String removeStars2(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for (char c:s.toCharArray()){
            if (c == '*'){
                if (!queue.isEmpty()){
                    queue.pollLast();
                }
            }else {
                queue.addLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            stringBuilder.append(queue.pollFirst());
        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();
        System.out.println(removeStars.removeStars("leet**cod*e"));
        System.out.println(removeStars.removeStars("erase*****"));
        System.out.println(removeStars.removeStars2("leet**cod*e"));
        System.out.println(removeStars.removeStars2("erase*****"));
    }
}
