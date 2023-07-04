package com.exercise.algorithm.listNode;

/**
 * @ClassName MiddleNode
 * @Description 链表的中间节点
 * @Author yeqiang
 * @Date 2022/7/4 11:11 AM
 * @Version 1.0
 **/
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode tempNode = head;
        while (tempNode != null){
            count++;
            tempNode = tempNode.next;
        }
        int middle = count / 2 + 1;
        count = 0;
        ListNode resNode = null;
        tempNode = head;
        while (tempNode != null){
            count++;
            if (count == middle){
                resNode = tempNode;
                break;
            }
            tempNode = tempNode.next;
        }
        return resNode;
    }

    //快慢指针
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
