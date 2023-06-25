package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换
 */
public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = Arrays.stream(arr).toArray();
        Arrays.sort(copyArr);
        int no = 1;
        Map<Integer, Integer>  arrNoMap = new HashMap<>();
        for (int num:copyArr){
            if (!arrNoMap.containsKey(num)){
                arrNoMap.put(num, no++);
            }
        }
        for (int i = 0; i < arr.length; i++){
            arr[i] = arrNoMap.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();
        System.out.println(Arrays.toString(arrayRankTransform.arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(arrayRankTransform.arrayRankTransform(new int[]{100, 100, 100})));
        System.out.println(Arrays.toString(arrayRankTransform.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }
}
