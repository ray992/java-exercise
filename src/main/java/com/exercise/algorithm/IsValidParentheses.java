package com.exercise.algorithm;

import java.util.Stack;

/**
 * @ClassName IsValidParentheses
 * @Description 有效的括号
 * @Author yeqiang
 * @Date 2021/10/27 上午10:58
 * @Version 1.0
 **/
public class IsValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> recordStack = new Stack<>();
        for (Character c:s.toCharArray()){
            Character topC = recordStack.isEmpty()?null:recordStack.peek();
            if (topC == null && ((c == ')' || c == '}' || c == ']'))){
                return false;
            }
            if ( (c == ')' && topC == '(') || (c == '}' && topC == '{') || (c == ']' && topC == '[')){
                recordStack.pop();
                continue;
            }
            recordStack.push(c);
        }
        return recordStack.isEmpty();
    }

    public static void main(String[] args) {
        IsValidParentheses isValidParentheses = new IsValidParentheses();
        System.out.println(isValidParentheses.isValid("()"));
        System.out.println(isValidParentheses.isValid("()[]{}"));
        System.out.println(isValidParentheses.isValid("(]"));
        System.out.println(isValidParentheses.isValid("([)]"));
        System.out.println(isValidParentheses.isValid("{[]}"));
    }

}
