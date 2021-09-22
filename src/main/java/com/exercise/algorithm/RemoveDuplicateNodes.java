package com.exercise.algorithm;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName RemoveDuplicateNodes
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午10:18
 * @Version 1.0
 **/
public class RemoveDuplicateNodes {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        Set<Integer> comparedSet = new HashSet<>();
        comparedSet.add(head.val);
        ListNode pos = head;
        while (pos.next != null){
           if (comparedSet.add(pos.next.val)){
               pos = pos.next;
           }else {
               pos.next = pos.next.next;
           }
        }
        pos.next = null;
        return head;
    }
}
