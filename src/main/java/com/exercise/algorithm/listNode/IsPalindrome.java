package com.exercise.algorithm.listNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName IsPalindrome
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午4:30
 * @Version 1.0
 **/
public class IsPalindrome {


    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        Deque<Integer> valQueue = new LinkedList<>();
        while (head != null){
            valQueue.addLast(head.val);
            head = head.next;
        }
        while (!valQueue.isEmpty()){
            int start = valQueue.pollFirst();
            if (valQueue.isEmpty()){
                return true;
            }
            int end = valQueue.pollLast();
            if (start != end){
                return false;
            }
        }
        return true;
    }
}
