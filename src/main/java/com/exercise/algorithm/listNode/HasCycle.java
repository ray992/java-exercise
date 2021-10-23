package com.exercise.algorithm.listNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HasCycle
 * @Description 环形链表
 * @Author yeqiang
 * @Date 2021/10/22 下午6:42
 * @Version 1.0
 **/
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<Integer> listCodeHashSet = new HashSet<>();
        while (head != null){
            if (!listCodeHashSet.add(head.hashCode())){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(12);
        System.out.println(listNode.hashCode());
    }
}
