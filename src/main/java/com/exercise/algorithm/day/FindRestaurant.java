package com.exercise.algorithm.day;

import java.util.*;

public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<String>>  matchResMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            for (int j = 0; j < list2.length; j++){
                if (list1[i].equals(list2[j])){
                    int curIndex = i + j;
                    if (curIndex < min){
                        min = curIndex;
                    }
                    List<String> curResList = matchResMap.get(curIndex);
                    if (curResList == null){
                        curResList = new ArrayList<>();
                        curResList.add(list1[i]);
                        matchResMap.put(curIndex, curResList);
                    }else {
                        curResList.add(list1[i]);
                    }
                }
            }
        }
        List<String> bestMatchResList = matchResMap.get(min);
        String[] res = new String[bestMatchResList.size()];
        return bestMatchResList.toArray(res);
    }

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        System.out.println(Arrays.toString(findRestaurant.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
