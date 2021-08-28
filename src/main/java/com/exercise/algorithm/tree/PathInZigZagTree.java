package com.exercise.algorithm.tree;

import java.util.*;

/**
 * @ClassName PathInZigZagTree
 * @Description 二叉树寻路
 * @Author yeqiang
 * @Date 2021/7/29 上午9:17
 * @Version 1.0
 **/
public class PathInZigZagTree {

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> pathList = new ArrayList<>();
        Deque<Integer> integerDeque = new LinkedList<>();
        integerDeque.add(label);
        int row = 1;
        int labelVal = label;
        while (true){
            int z = labelVal / 2;
            row ++;
            if (z == 1){
                break;
            }
            labelVal = z;
        }
        int parentLabel;
        while (row > 1){
            if (row % 2 == 0){
                int mirrorLabel = ((1<<row)-1) - (label - (1<<(row-1)));
                if (mirrorLabel % 2 == 0){
                    parentLabel = mirrorLabel >> 1;
                }else {
                    parentLabel = (mirrorLabel - 1) >> 1;
                }
                label = parentLabel;
                integerDeque.add(parentLabel);
            }else {
                if (label % 2 == 0){
                    parentLabel = label >> 1;
                }else {
                    parentLabel = (label-1) >> 1;
                }
                int parentMirror = ((1<<(row-1))-1) - (parentLabel -(1<<(row-2)));
                label = parentMirror;
                integerDeque.add(parentMirror);
            }
            row --;
        }
        while (integerDeque.size() > 0){
            pathList.add(integerDeque.pollLast());
        }
        return pathList;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
        System.out.println(pathInZigZagTree(26));
        System.out.println(pathInZigZagTree(1000000));
        //System.out.println(1<<4);
    }
}
