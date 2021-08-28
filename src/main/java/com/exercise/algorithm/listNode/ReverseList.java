package com.exercise.algorithm.listNode;

import java.util.Arrays;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/2 下午11:30
 * @Version 1.0
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode[] arrayNode = new ListNode[5000];
        Arrays.fill(arrayNode, null);
        int i = 0;
        while (head != null){
            arrayNode[i] = head;
            i++;
            head = head.next;
        }
        ListNode preNode = new ListNode(-1);
        ListNode tempNode = preNode;
        for (int j = i-1; j >=0; j--){
            tempNode.next = new ListNode(arrayNode[j].val);
            tempNode = tempNode.next;
        }
        return preNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        head.next = listNode1;
        ListNode listNode2 = new ListNode(6);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        listNode6.next = null;
        ReverseList reverseList = new ReverseList();
        ListNode listNode_  = reverseList.reverseList(head);
        while (listNode_ != null){
            System.out.println(listNode_.val);
            listNode_ = listNode_.next;
        }
    }
}
