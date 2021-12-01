package com.exercise.algorithm.day;

import com.exercise.algorithm.listNode.ListNode;

/**
 * @ClassName DeleteNode
 * @Description 删除节点
 * @Author yeqiang
 * @Date 2021/11/2 下午11:02
 * @Version 1.0
 **/
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
