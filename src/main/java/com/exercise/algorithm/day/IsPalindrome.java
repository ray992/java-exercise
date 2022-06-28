package com.exercise.algorithm.day;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayList;

/**
 * @ClassName IsPalindrome
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午10:54
 * @Version 1.0
 **/
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ArrayList<Integer> valList = new ArrayList<>();
        valList.add(head.val);
        while (head.next != null){
            valList.add(head.next.val);
            head = head.next;
        }
        int size = valList.size();
        int i = 0;
        int j = 0;
        while ( i <= j){
            j = size - 1 - i;;
            if (!valList.get(i).equals(valList.get(j))){
                return false;
            }
            i++;
        }
        return true;
    }
}
