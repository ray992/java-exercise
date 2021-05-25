package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ListNode1
 * @Description 反转链表
 * @Author yeqiang
 * @Date 2021/3/18 10:02 下午
 * @Version 1.0
 **/
public class ListNode1 {

    public static class ListNode{

        private int val;

        private ListNode next;

        public ListNode(){

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return null;
        }
        int i = 1;
        ListNode temp = head;
        boolean hit;
        Stack<ListNode> listNodeStack = new Stack<>();
        List<ListNode> preList = new ArrayList<>();
        List<ListNode> afterList = new ArrayList<>();
        while (true){
            if (i >= left && i <= right){
                listNodeStack.add(temp);
                hit = true;
            }else {
                hit = false;
            }
            if (!hit){
                if (i < left){
                    preList.add(temp);
                }
                if (i > right){
                    afterList.add(temp);
                }
            }
            temp = temp.next;
            i ++;
            if (temp == null){
                break;
            }
        }
        ListNode newListNode = new ListNode();
        ListNode tempNode = newListNode;
        if (preList.size() > 0){
            for (ListNode listNode:preList){
                tempNode.next = listNode;
                tempNode = tempNode.next;
            }
        }
        if (listNodeStack.size() > 0){
            while (!listNodeStack.isEmpty()){
                tempNode.next = listNodeStack.pop();
                tempNode = tempNode.next;
            }
        }
        if (afterList.size() > 0){
            for (ListNode listNode:afterList){
                tempNode.next = listNode;
                tempNode = tempNode.next;
            }
        }
       return newListNode.next;
    }

    public static void main(String[] args) {
       /* ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;*/
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);
        ListNode temp = reverseBetween(listNode1, 1, 2);
        while (true){
            System.out.println(temp.val);
            temp = temp.next;
            if (temp == null){
                break;
            }
        }
    }
}
