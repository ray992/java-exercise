package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//找出星型图的中心节点
public class FindCenter {

    public int findCenter(int[][] edges) {
        Map<Integer, Set<Integer>>  crossPathMap = new HashMap<>();
        for (int[] edge : edges) {
            int ui = edge[0];
            int vi = edge[1];
            if (crossPathMap.containsKey(ui)) {
                crossPathMap.get(ui).add(vi);
            } else {
                Set<Integer> viSet = new HashSet<>();
                viSet.add(vi);
                crossPathMap.put(ui, viSet);
            }
            if (crossPathMap.containsKey(vi)) {
                crossPathMap.get(vi).add(ui);
            } else {
                Set<Integer> uiSet = new HashSet<>();
                uiSet.add(ui);
                crossPathMap.put(vi, uiSet);
            }
        }
        int allNodeCount = crossPathMap.keySet().size();
        for (Map.Entry<Integer, Set<Integer>> map:crossPathMap.entrySet()){
            if (map.getValue().size() == allNodeCount - 1){
                return map.getKey();
            }
        }
        return -1;
    }

    public int findCenter2(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }


    public static void main(String[] args) {
        FindCenter findCenter = new FindCenter();
        System.out.println(findCenter.findCenter2(new int[][]{{1,2}, {2, 3}, {4, 2}}));
        System.out.println(findCenter.findCenter2(new int[][]{{1,2}, {5, 1}, {1, 3}, {1,4}}));
    }
}
