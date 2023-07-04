package com.exercise.algorithm.listNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName MergeTwoLists
 * @Description 合并两个有序链表
 * @Author yeqiang
 * @Date 2022/7/4 10:00 AM
 * @Version 1.0
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode preNode = new ListNode(-1);
        ListNode tempNode = preNode;
        List<Integer> valList = new ArrayList<>();
        while (list1 != null || list2 != null){
            if (list1 != null){
                valList.add(list1.val);
                list1 = list1.next;
            }
            if (list2 != null){
                valList.add(list2.val);
                list2 = list2.next;
            }
        }
        Collections.sort(valList);
        for (int val:valList){
            tempNode.next = new ListNode(val);
            tempNode = tempNode.next;
        }
        return preNode.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list2.next, list1);
        return list2;
    }
}
