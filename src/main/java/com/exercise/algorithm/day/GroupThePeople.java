package com.exercise.algorithm.day;

import java.util.*;

/**
 * 用户分组
 */
public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Deque<Integer>>  groupMap = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++){
            Deque<Integer> indexDeque = groupMap.getOrDefault(groupSizes[i], new LinkedList<>());
            indexDeque.addLast(i);
            groupMap.put(groupSizes[i], indexDeque);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Deque<Integer>> map:groupMap.entrySet()){
            int size = map.getKey();
            Deque<Integer> indexDeque = map.getValue();
            int counter = 1;
            List<Integer> childIndexList = new ArrayList<>();
            while (!indexDeque.isEmpty()){
                childIndexList.add(indexDeque.pollFirst());
                if (counter % size == 0){
                    counter = 1;
                    List<Integer> tempList = new ArrayList<>(childIndexList);
                    resultList.add(tempList);
                    childIndexList = new ArrayList<>();
                    continue;
                }
                counter++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        System.out.println(groupThePeople.groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople.groupThePeople(new int[]{2,1,3,3,3,2}));
    }
}
