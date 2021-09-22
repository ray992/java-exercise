package com.exercise.algorithm.day;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName CheckValidString
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/12 上午10:55
 * @Version 1.0
 **/
public class CheckValidString {

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> commonStack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '('){
                leftStack.push(i);
            }else if (chars[i] == '*'){
                commonStack.push(i);
            }else {
                if (!leftStack.isEmpty()){
                    leftStack.pop();
                }else if (!commonStack.isEmpty()){
                    commonStack.poll();
                }else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !commonStack.isEmpty()){
            int l1 = leftStack.pop();
            int l2 = commonStack.pop();
            if (l1 > l2){
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
