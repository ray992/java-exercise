package com.exercise.algorithm.cycleNode;

/**
 * @ClassName Insert
 * @Description 循环单调非递减列表
 * @Author yeqiang
 * @Date 2022/6/18 9:50 AM
 * @Version 1.0
 **/
public class Insert {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null){
            node.next = node;
            return node;
        }
        if (head == head.next){
            head.next = node;
            node.next = head;
            return head;
        }
        Node curNode = head;
        Node nextNode = head.next;
        while (head != nextNode){
            if (insertVal >= curNode.val && insertVal <= nextNode.val){
                break;
            }
            if (curNode.val > nextNode.val){
                if (insertVal > curNode.val || insertVal < nextNode.val){
                    break;
                }
            }
            curNode = curNode.next;
            nextNode = nextNode.next;
        }
        curNode.next = node;
        node.next = nextNode;
        return head;
    }
}

class Node {
    public int val;
    public Node next;



    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}