package com.exercise.algorithm.listNode;

/**
 * @ClassName RemoveNthFromEnd
 * @Description 删除链表的倒数第N个节点
 * @Author yeqiang
 * @Date 2021/11/3 上午9:16
 * @Version 1.0
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp1 = head;
        ListNode temp2 = head;
        while (temp1 != null){
            count++;
            temp1 = temp1.next;
        }
        if (count == 1 && n == 1){
            return null;
        }
        int turn = count - n + 1;
        ListNode preNode = null;
        ListNode targetNode = null;
        int _count = 0;
        while (temp2 != null){
            _count++;
            if (_count == turn -1){
                preNode = temp2;
            }
            if (_count == turn){
                targetNode = temp2;
                break;
            }
            temp2 = temp2.next;
        }
        assert targetNode != null;
        if (targetNode.next != null){
            targetNode.val = targetNode.next.val;
            targetNode.next = targetNode.next.next;
        }else {
            assert preNode != null;
            preNode.next = null;
        }
        return head;
    }
}
