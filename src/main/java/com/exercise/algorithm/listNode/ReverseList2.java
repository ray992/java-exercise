package com.exercise.algorithm.listNode;

/**
 * @ClassName ReverseList2
 * @Description 反转链表
 * @Author yeqiang
 * @Date 2022/7/4 10:35 AM
 * @Version 1.0
 **/
public class ReverseList2 {

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next= pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public ListNode reverseList2(ListNode head) {
        ListNode ans = null;
        for (ListNode x = head; x != null; x = x.next) {
            ans = new ListNode(x.val,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseList2   reverseList2 = new ReverseList2();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2, null);
        System.out.println(reverseList2.reverseList2(listNode));
    }
}
