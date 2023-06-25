package com.exercise.algorithm.day;

import java.util.*;

public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer>  numMap = new HashMap<>();
        for (int num:nums){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        List<CompareData> compareDataList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> map:numMap.entrySet()){
            compareDataList.add(new CompareData(map.getKey(), map.getValue()));
        }
        compareDataList.sort(new Comparator<CompareData>() {
            @Override
            public int compare(CompareData o1, CompareData o2) {
                return o1.getFrequent() != o2.getFrequent() ? o1.getFrequent() - o2.getFrequent() : o2.getVal() - o1.getVal();
            }
        });
        int[] result = new int[nums.length];
        int i = 0;
        for (CompareData compareData:compareDataList){
            int val = compareData.getVal();
            int frequent = compareData.getFrequent();
            for (int j = 0; j < frequent; j++, i++){
                result[i] = val;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(Arrays.toString(frequencySort.frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(frequencySort.frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(frequencySort.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }

    static class CompareData {
        int val;

        int frequent;

        public CompareData(int val, int frequent) {
            this.val = val;
            this.frequent = frequent;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getFrequent() {
            return frequent;
        }

        public void setFrequent(int frequent) {
            this.frequent = frequent;
        }
    }

}
