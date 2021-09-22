package com.exercise.algorithm.tree;

import com.exercise.algorithm.listNode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName ListOfDepth
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/10 上午8:54
 * @Version 1.0
 **/
public class ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> lists=new ArrayList<>();
        if(tree != null){
            queue.add(tree);
        }
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode tmp=queue.poll();
                list.add(tmp.val);
                if(tmp.left !=null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            lists.add(list);
        }
        ListNode[] a=new ListNode[lists.size()];

        for(int i=0;i<lists.size();i++){
            ListNode l=new ListNode(0);
            ListNode ll=l;
            for(int j=0;j<lists.get(i).size();j++){
                ListNode tmp=new ListNode(lists.get(i).get(j));
                l.next=tmp;
                l=l.next;
            }
            a[i]=ll.next;
        }
        return a;
    }


    public static void main(String[] args) {
        
    }



}
