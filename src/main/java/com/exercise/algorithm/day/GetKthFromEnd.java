package com.exercise.algorithm.day;

import com.exercise.algorithm.listNode.ListNode;

/**
 * @ClassName GetKthFromEnd
 * @Description 链表中倒数第k个节点
 * @Author yeqiang
 * @Date 2021/9/2 上午9:30
 * @Version 1.0
 **/
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int i = 0;
        while (temp != null){
            i ++;
            temp = temp.next;
        }
        int j = 0;
        ListNode result = null;
        while (head != null){
            j ++;
            if ( j == i - k + 1){
                result = head;
                break;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        System.out.println(getKthFromEnd.foo());
    }


    public int foo() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
