package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName BusLine
 * @Description 公交路线， 广度优先算法
 * @Author yeqiang
 * @Date 2021/2/4 9:04 下午
 * @Version 1.0
 **/
public class BusLine {

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        int length = routes.length;
        if (length == 0){
            return -1;
        }
        Set<Integer> sourceLineSet = new HashSet<>(); //包含S站的线路
        Set<Integer> targetLineSet = new HashSet<>(); //包含T站的线路
        for (int j = 0 ; j < length; j ++){
            int[] line = routes[j];
            if (line.length == 0){
                continue;
            }
            for (int i = 0 ; i < line.length; i ++){
                if (source == line[i]){
                    sourceLineSet.add(j);
                }
                if (target == line[i]){
                    targetLineSet.add(j);
                }
            }
        }
        //是否命中
        if (sourceLineSet.size() == 0 || targetLineSet.size() == 0){
            return -1;
        }
        for (Integer sourceLine:sourceLineSet){
            if (targetLineSet.contains(sourceLine)){
                return 1;
            }
        }
        //不再一条线上
        Map<Integer, List<Integer>> routeMap = new HashMap<>();
        // 标记是否访问过
        Boolean[] isVisited = new Boolean[routes.length];
        for (int i = 0; i < routes.length; i++) {
            isVisited[i] = false;
            routeMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < routes.length; i++){
            for (int j = i + 1; j < routes.length; j++){
                if(haveCommonStation(routes[i], routes[j])){
                    routeMap.get(i).add(j);
                    routeMap.get(j).add(i);
                }
            }
        }
        boolean hasReached = false;
        int count = 1;
        while (!hasReached) {
            count++;
            Set<Integer> newSourceLineSet = new HashSet<>();
            for (Integer _source : sourceLineSet) {
                for (Integer routeItem : routeMap.get(_source)) {
                    if (newSourceLineSet.contains(routeItem)) {
                        continue;
                    }
                    if (isVisited[routeItem]) {
                        continue;
                    }
                    isVisited[routeItem] = true;
                    newSourceLineSet.add(routeItem);
                }
            }
            if (newSourceLineSet.size() == 0) {
                break;
            }
            sourceLineSet = newSourceLineSet;
            for (Integer _target : targetLineSet) {
                if (sourceLineSet.contains(_target)) {
                    hasReached = true;
                }
            }
        }
        return hasReached?count:-1;
    }

    private static Boolean haveCommonStation(int[] a , int[] b){
        int m =0 , n = 0;
        while (m < a.length && n < b.length){
            if (a[m] == b[n]){
                return Boolean.TRUE;
            }
            if (a[m] < b[n]){
                m++;
            }else {
                n++;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7},{3, 6, 7},{7, 8, 9}};
        System.out.println(numBusesToDestination(routes, 1, 8));
    }
}
