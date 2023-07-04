package com.exercise.algorithm.listNode;

import java.util.HashSet;

/**
 * @ClassName DetectCycle
 * @Description 环形链表
 * @Author yeqiang
 * @Date 2022/7/4 11:29 AM
 * @Version 1.0
 **/
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visitedHashSet = new HashSet<>();
        while (head != null){
            if (visitedHashSet.contains(head)){
                return head;
            }
            visitedHashSet.add(head);
            head = head.next;
        }
        return null;
    }
}
