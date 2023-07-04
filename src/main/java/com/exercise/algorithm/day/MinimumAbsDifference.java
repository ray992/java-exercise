package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumAbsDifference
 * @Description 最小绝对差
 * @Author yeqiang
 * @Date 2022/7/4 8:19 AM
 * @Version 1.0
 **/
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++){
            int diff = arr[i] - pre;
            minAbsDiff = Math.min(minAbsDiff, diff);
            pre = arr[i];
        }
        List<List<Integer>> resultList = new ArrayList<>();
        pre = arr[0];
        for (int i = 1; i < arr.length; i++){
            int diff = arr[i] - pre;
            if (diff == minAbsDiff){
                List<Integer> childList = new ArrayList<>();
                childList.add(pre);
                childList.add(arr[i]);
                resultList.add(childList);
            }
            pre = arr[i];
        }
        return resultList;
    }

    public static void main(String[] args) {
        MinimumAbsDifference minimumAbsDifference = new MinimumAbsDifference();
        System.out.println(minimumAbsDifference.minimumAbsDifference(new int[]{4,2,1,3}));
    }
}
