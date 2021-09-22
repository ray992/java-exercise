package com.exercise.algorithm.day;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName SplitListToParts
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/22 上午9:34
 * @Version 1.0
 **/
public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        while (head != null){
            nodeList.add(head.val);
            head = head.next;
        }
        int size = nodeList.size();
        int modPart = size % k;
        int partLength = size/k;
        if (modPart == 0){
            ListNode[] listNodeArray = new ListNode[partLength];
            int listNodeArrayIndex = 0;
            ListNode preListNode = new ListNode(-1);
            ListNode temp = preListNode;
            for (int i = 0; i < size; i++){
                temp.next = new ListNode(nodeList.get(i));
                temp = temp.next;
                if ((i+1) % partLength == 0){
                    listNodeArray[listNodeArrayIndex] = preListNode.next;
                    listNodeArrayIndex++;
                    preListNode = new ListNode(-1);
                    temp = preListNode;
                }
            }
            return listNodeArray;
        }
        int actualPartLength = (partLength > 0)?partLength:k;
        ListNode[] listNodeArray = new ListNode[actualPartLength];
        int listNodeArrayIndex = 0;
        int balanceTimes = 1;
        ListNode preListNode = new ListNode(-1);
        ListNode temp = preListNode;
        if (partLength > 0){
            for (int i = 0; i < size; i++){
                temp.next = new ListNode(nodeList.get(i));
                temp = temp.next;
                if ( (i+1) % (partLength+balanceTimes) == 0){
                    listNodeArray[listNodeArrayIndex] = preListNode.next;
                    listNodeArrayIndex++;
                    preListNode = new ListNode(-1);
                    temp = preListNode;
                    if (balanceTimes < modPart){
                        balanceTimes++;
                    }
                }
            }
        }else {
            int i = 0;
            while (i < k){
                preListNode.next = (i < size)? (new ListNode(nodeList.get(i))):null;
                listNodeArray[listNodeArrayIndex] = preListNode.next;
                listNodeArrayIndex++;
                preListNode = new ListNode(-1);
                i++;
            }
        }
        return listNodeArray;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        SplitListToParts splitListToParts = new SplitListToParts();
        ListNode[] result = splitListToParts.splitListToParts(listNode, 3);
        System.out.println(Arrays.toString(result));
    }
}
