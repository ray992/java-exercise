package com.exercise.algorithm.day;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddTwoNumbers
 * @Description 两数相加
 * @Author yeqiang
 * @Date 2021/11/2 下午11:22
 * @Version 1.0
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        int pre = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null?l1.val:0;
            int n2 = l2 != null?l2.val:0;
            if (n1 + n2 + pre >= 10){
                resultList.add(n1+n2-10+pre);
                pre = 1;
            }else {
                resultList.add(n1+n2+pre);
                pre = 0;
            }
            l1 = l1 == null ? null:l1.next;
            l2 = l2 == null ?null: l2.next;
        }
        if (pre > 0){
            resultList.add(pre);
        }
        ListNode preListNode = new ListNode(-1);
        ListNode tempListNode = preListNode;
        for (int i = 0; i < resultList.size();i++){
            tempListNode.next = new ListNode(resultList.get(i));
            tempListNode = tempListNode.next;
        }
        return preListNode.next;
    }
}
