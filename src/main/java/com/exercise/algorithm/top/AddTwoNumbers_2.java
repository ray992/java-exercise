package com.exercise.algorithm.top;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

//两数相加
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tempRes = res;
        Deque<Integer> d1 = new ArrayDeque<>();
        while (l1 != null){
            d1.addLast(l1.val);
            l1 = l1.next;
        }
        Deque<Integer> d2 = new ArrayDeque<>();
        while (l2 != null){
            d2.addLast(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        Deque<Integer> d3 = new ArrayDeque<>();
        while (!d1.isEmpty() || !d2.isEmpty()){
            int n1 =  d1.peekFirst() == null ? 0: d1.pollFirst();
            int n2 =  d2.peekFirst() == null ? 0: d2.pollFirst();
            int temp = carry + n1 + n2;
            if (temp >= 10){
                temp = temp - 10;
                carry = 1;
            }else {
                carry = 0;
            }
            d3.addLast(temp);
        }
        //注意进位，容易忽略
        if (carry == 1){
            d3.addLast(carry);
        }
        while (!d3.isEmpty()){
            tempRes.next = new ListNode(d3.pollFirst());
            tempRes = tempRes.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l211 = new ListNode(4);
        l2.next = l21;
        l21.next = l211;

        AddTwoNumbers_2 addTwoNumbers2 = new AddTwoNumbers_2();
        System.out.println(addTwoNumbers2.addTwoNumbers(l1, l2));
    }
}
