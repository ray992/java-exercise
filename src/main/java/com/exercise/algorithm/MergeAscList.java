package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MergeAscList
 * @Description 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @Author yeqiang
 * @Date 2021/1/24 7:37 下午
 * @Version 1.0
 **/
public class MergeAscList {

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> mergeList = new ArrayList<>();
        for (ListNode listNode:lists){
            if (listNode != null){
                mergeList(listNode, mergeList);
            }
        }
        System.out.println(mergeList);
        Integer[] ascArray = new Integer[mergeList.size()];
        mergeList.toArray(ascArray);
        Arrays.sort(ascArray);
        ListNode point;
        ListNode head;
        head = point = new ListNode(0);
        for (int i = 0 ; i < ascArray.length ; i ++){
            point.next = new ListNode(ascArray[i]);
            point = point.next;
        }
        return head.next;
    }

    public static void mergeList(ListNode listNode, List<Integer> mergeList ){
        if (listNode != null){
            mergeList.add(listNode.val);
            mergeList(listNode.next, mergeList);
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(2);
        listNode6.next = new ListNode(6);

        ListNode[] listNodes = {listNode, listNode3, listNode6};
        ListNode orderListNode = mergeKLists(listNodes);
        while (orderListNode != null){
            System.out.print(orderListNode.val+ " ");
            orderListNode = orderListNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
