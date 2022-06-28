package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EventualSafeNodes
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/5 上午9:19
 * @Version 1.0
 **/
public class EventualSafeNodes {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++){
            int[] line = graph[i];
            if (travsal(line, graph)){
                nodeList.add(i);
            }
        }
        return nodeList;
    }

    public boolean travsal(int[] line, int[][] graph){
        if (line == null || line.length == 0){
            return true;
        }
        for (int j = 0; j < line.length; j++){
            if (travsal(graph[line[j]], graph)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
        List<Integer> result = eventualSafeNodes.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
        System.out.println(result);
    }
}
