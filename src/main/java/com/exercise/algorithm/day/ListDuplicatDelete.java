package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ListDuplicatDelete
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/26 9:26 下午
 * @Version 1.0
 **/
public class ListDuplicatDelete {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead  = new ListNode();
        ListNode t = newHead;
        List<ListNode> listNodeList = new ArrayList<>();
        Set<Integer> valSet = new HashSet<>();
        while (head != null){
            if (valSet.contains(head.val)){
                head = head.next;
            }else {
                valSet.add(head.val);
                listNodeList.add(new ListNode(head.val));
            }
        }
        for (ListNode listNode:listNodeList){
            t.next =listNode;
            t = t.next;
        }
        return newHead.next;
    }
}
