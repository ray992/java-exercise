package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName NumRescueBoats
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/26 上午9:21
 * @Version 1.0
 **/
public class NumRescueBoats {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int sum = 0;
        int i = 0;
        int diff = 0;
        while (i < people.length) {
            if (people[i] > limit) {
                break;
            }
            diff = limit - people[i];
            if ((i+1) < people.length && diff >= people[i+1]){
                i = i+2;
            }else {
                i++;
            }
            sum ++;
        }
        return sum;
    }

    public int numRescueBoats2(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public void findMatchPeople(Map<Integer, List<Integer>> weightMap, int weight, Set<Integer> using){
       List<Integer> indexList = weightMap.get(weight);
       if (indexList == null){
           return;
       }
       for (int index:indexList){
           if (using.contains(index)){
               continue;
           }
           using.add(index);
           break;
       }
    }

    public static void main(String[] args) {
        NumRescueBoats numRescueBoats = new NumRescueBoats();
        //System.out.println(numRescueBoats.numRescueBoats2(new int[]{1,2}, 3));
        //System.out.println(numRescueBoats.numRescueBoats2(new int[]{3,2,2,1}, 3));
        //System.out.println(numRescueBoats.numRescueBoats2(new int[]{3,5,3,4}, 5));
        //System.out.println(numRescueBoats.numRescueBoats2(new int[]{5,1,4,2}, 6));
        System.out.println(numRescueBoats.numRescueBoats2(new int[]{3,2,3,2,2}, 6));
    }
}
