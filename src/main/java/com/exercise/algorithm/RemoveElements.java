package com.exercise.algorithm;

import com.exercise.algorithm.listNode.ListNode;

/**
 * @ClassName RemoveElements
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/2 下午10:23
 * @Version 1.0
 **/
public class RemoveElements {

    public ListNode pre = new ListNode(-1);

    public ListNode temp = pre;

    public int n = 0;
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        doRemove(head, val);
        ListNode listNode  = pre.next;
        ListNode pp = listNode;
        int i = 0;
        while (pp != null){
            i++;
            if (i == n-1){
                pp.next = null;
                break;
            }
            pp = pp.next;
        }
        return listNode;
    }

    public void doRemove(ListNode listNode, int val){
        if (listNode == null){
            return;
        }
        n++;
        int currentVal = listNode.val;
        if (currentVal != val){
            temp.next = listNode;
            temp = temp.next;
        }
        doRemove(listNode.next, val);
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
        RemoveElements removeElements = new RemoveElements();
        ListNode listNode = removeElements.removeElements(head,6);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
