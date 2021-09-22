package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FindWhetherExistsPath
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/9 下午11:11
 * @Version 1.0
 **/
public class FindWhetherExistsPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //建立邻接表 list
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(n);//共有n个节点
        //首先增加n个集合
        for(int i = 0;i < n;i++){
            list.add(new ArrayList<>());
        }
        //节点的编号对应集合的位置,存放与该节点相邻的节点的编号
        for(int i = 0;i < graph.length;i++){
            list.get(graph[i][0]).add(graph[i][1]);
        }
        //队列queue存放当前节点以及访问过但尚未扩展的节点
        Queue<Integer> queue = new LinkedList<Integer>();
        //数组visited存放是否已经访问该节点的标志
        boolean[] visited = new boolean[n];
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int j = 0;j < list.get(cur).size();j++){
                int node = list.get(cur).get(j);
                //如果当前节点没有访问过
                if(!visited[node]){
                    visited[node] = true;
                    if(node == target){
                        return true;
                    }
                    //将该节点放入队列中
                    queue.add(node);
                }
            }
        }
        return false;
    }

}
