package com.exercise.algorithm.listNode;

import java.util.Stack;

/**
 * @ClassName ReversePrint
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午5:35
 * @Version 1.0
 **/
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        int[] array = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            array[i] = stack.pop();
            i++;
        }
        return array;
    }
}
