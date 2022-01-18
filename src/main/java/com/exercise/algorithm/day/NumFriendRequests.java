package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NumFriendRequests
 * @Description 诗龄的朋友
 * @Author yeqiang
 * @Date 2021/12/27 下午1:19
 * @Version 1.0
 **/
public class NumFriendRequests {

    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int total = 0;
        Set<String> matchConnection = new HashSet<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                if ((ages[i] <= 0.5*ages[j] + 7) || (ages[i] > ages[j]) || (ages[i] > 100 && ages[j] < 100)){
                    continue;
                }
                if (matchConnection.contains(j+"_"+i)){
                    continue;
                }
                matchConnection.add(j+"_"+i);
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        NumFriendRequests numFriendRequests = new NumFriendRequests();
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16,16}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{16,17, 18}));
        System.out.println(numFriendRequests.numFriendRequests(new int[]{20,30,100,110,120}));
    }
}
