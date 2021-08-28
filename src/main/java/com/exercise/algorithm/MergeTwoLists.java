package com.exercise.algorithm;

import com.exercise.algorithm.listNode.ListNode;

/**
 * @ClassName MergeTwoLists
 * @Description 合并两个有序链表
 * @Author yeqiang
 * @Date 2021/8/1 下午11:17
 * @Version 1.0
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int t1 = 0, t2 = 0;
        ListNode root = new ListNode(-1); //哨兵
        ListNode tempNode = root;
        boolean l1Teminal = false;
        boolean l2Teminal = false;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                t1 = l1.val;
            }
            if (l2 != null) {
                t2 = l2.val;
            }
            if (l1Teminal) {
                tempNode.next = new ListNode(t2);
                tempNode = tempNode.next;
                continue;
            }
            if (l2Teminal) {
                tempNode.next = new ListNode(t1);
                tempNode = tempNode.next;
                continue;
            }
            ListNode tempListNode = null;
            if (t1 < t2) {
                tempListNode = new ListNode(t1);
                if (l1 != null) {
                    l1 = l1.next;
                } else {
                    l1Teminal = true;
                }
            } else {
                tempListNode = new ListNode(t2);
                if (l2 != null) {
                    l2 = l2.next;
                } else {
                    l2Teminal = true;
                }
            }
            tempNode.next = tempListNode;
            tempNode = tempNode.next;
        }
        return root.next;
    }

    public static void main(String[] args) {

    }


}



