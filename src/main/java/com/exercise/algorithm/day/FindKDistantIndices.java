package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class FindKDistantIndices {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == key){
                indexList.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < indexList.size(); j++){
                if (Math.abs(indexList.get(j) - i) <= k){
                    resultList.add(i);
                    break;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        FindKDistantIndices findKDistantIndices = new FindKDistantIndices();
        System.out.println(findKDistantIndices.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
        System.out.println(findKDistantIndices.findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));
    }
}
