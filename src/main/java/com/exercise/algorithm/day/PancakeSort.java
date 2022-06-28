package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 煎饼排序
 */
public class PancakeSort {

    public List<Integer> pancakeSort(int[] arr) {
        //复制一份原数组
        int n = arr.length;
        int[] backArr = new int[n];
        System.arraycopy(arr, 0, backArr, 0, n);
        //先排好序
        Arrays.sort(backArr);
        List<Integer> resultList = new ArrayList<>();
        //每次确定一个元素
        for (int i = n - 1; i >= 0; i--){
            int curElement = backArr[i];
            int curPos = 0;
            for (int j = 0; j < n; j++){
                if (arr[j] == curElement){
                    curPos = j;
                    break;
                }
            }
            //如果当前要排的元素刚好在这个位置上，就不需要进行翻转
            if (curPos == i){
                continue;
            }
            //如果不在第一个元素，需要额外再翻一次
            if (curPos > 0 ){
                resultList.add(curPos + 1);
                flipArray(arr, 0, curPos);
            }
            resultList.add(i+1);
            flipArray(arr, 0, i);
        }
        return resultList;
    }

    //元素翻转
    public void flipArray(int[] arr, int start, int end){
        int temp = 0;
        for (int i = start; i <= (end - start )/2; i++){
            temp = arr[i];
            arr[i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

    public static void main(String[] args) {
        PancakeSort pancakeSort = new PancakeSort();
        List<Integer> resultList = pancakeSort.pancakeSort(new int[]{3,2,4,1});
        System.out.println(resultList);
        resultList = pancakeSort.pancakeSort(new int[]{1, 2, 3});
        System.out.println(resultList);
    }
}
