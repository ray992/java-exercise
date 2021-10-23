package com.exercise.algorithm.listNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GetIntersectionNode
 * @Description 相交链表
 * @Author yeqiang
 * @Date 2021/10/22 下午7:03
 * @Version 1.0
 **/
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        while (headA != null){
            list1.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            list2.add(headB);
            headB = headB.next;
        }
        for (ListNode listNode:list1){
            if (list2.contains(listNode)){
                return listNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
