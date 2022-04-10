package com.exercise.algorithm.day;

import java.util.*;

public class SortJumbled {

    Map<Character, Integer> numberMap = new HashMap<>();

    public int[] sortJumbled(int[] mapping, int[] nums) {
        for(int i = 0; i <= 9;i++){
            numberMap.put((char) ('0'+i), i);
        }
        int n = nums.length;
        int[] mappingAfter = new int[n];
        Map<Integer, List<Integer>> mappingIndexMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++){
            int cur = nums[i];
            int change = mapping(cur, mapping);
            mappingAfter[i] = change;
            if (!mappingIndexMap.containsKey(change)){
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                mappingIndexMap.put(change, indexList);
            }else {
                mappingIndexMap.get(change).add(i);
            }
        }
        int[] orderIndex = new int[n];
        Arrays.sort(mappingAfter);
        int i = 0;
        while (i < n){
            List<Integer> indexList = mappingIndexMap.get(mappingAfter[i]);
            int size = indexList.size();
            Integer[] tempArray = new Integer[size];
            tempArray = indexList.toArray(tempArray);
            Arrays.sort(tempArray);
            for (int j = 0; j < size; j++){
                orderIndex[i+j] = tempArray[j];
            }
            i = i + size;
        }
        int[] res = new int[n];
        for (int p = 0; p < n; p++){
            res[p] = nums[orderIndex[p]];
        }
        return res;
    }

    public static void main(String[] args) {
        SortJumbled sortJumbled = new SortJumbled();
        System.out.println(Arrays.toString(sortJumbled.sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(sortJumbled.sortJumbled(new int[]{0,1,2,3,4,5,6,7,8,9}, new int[]{789,456,123})));
    }

    public int mapping(int cur, int[] mapping){
        char[] chars = String.valueOf(cur).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            sb = sb.append(mapping[numberMap.get(c)]);
        }
        String mappingNumberString = sb.toString();
        if (mappingNumberString.startsWith("0")){
            int startIndex = 0;
            for (int i = 0; i < mappingNumberString.length(); i++){
                if (mappingNumberString.charAt(i) != '0'){
                    startIndex = i;
                    break;
                }
            }
            return Integer.parseInt(mappingNumberString.substring(startIndex));
        }
        return Integer.parseInt(mappingNumberString);
    }
}
