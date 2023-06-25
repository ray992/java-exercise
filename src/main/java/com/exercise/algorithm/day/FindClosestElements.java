package com.exercise.algorithm.day;

import java.util.*;

// 找到K个最接近的元素
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int num: arr){
            int diff = Math.abs(num - x);
            List<Integer> numList = treeMap.getOrDefault(diff, new ArrayList<>());
            numList.add(num);
            treeMap.put(diff, numList);
        }
        List<Integer>  resultList = new ArrayList<>();
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> map:treeMap.entrySet()){
            List<Integer> numList = map.getValue();
            for (int num:numList){
                if (count >= k){
                    break;
                }
                resultList.add(num);
                count ++;
            }
        }
        Collections.sort(resultList);
        return resultList;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x){
        List<Integer> list = new ArrayList<>();
        for (int num:arr){
            list.add(num);
        }
        list.sort((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> resultList = list.subList(0, k);
        Collections.sort(resultList);
        return resultList;
    }


    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements2(new int[]{1,2,3,4,5}, 2, 4));
    }
}
