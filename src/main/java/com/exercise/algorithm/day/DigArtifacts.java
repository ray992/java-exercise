package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

public class DigArtifacts {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<String> digSetPosition = new HashSet<>();
        for (int[] ints : dig) {
            digSetPosition.add(ints[0] + "_" + ints[1]);
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            int x1 = artifact[0];
            int y1 = artifact[1];
            int x2 = artifact[2];
            int y2 = artifact[3];
            boolean matchStatus = true;
            if ((x2 -x1 > 0 && y2 - y1 >1) || (y2 - y1 > 0 && x2 - x1 > 0)){
                matchStatus = false;
            }
            if (x1 == x2 && y2 - y1 <= 3){
                for (int i = y1 ; i<= y2; i++){
                    if (!digSetPosition.contains(x1 + "_" + i)){
                        matchStatus = false;
                        break;
                    }
                }
            }
            if (y1 == y2 && x2 - x1 <= 3){
                for (int i = x1; i <= x2; i++){
                    if (!digSetPosition.contains(i + "_" + y1)){
                        matchStatus = false;
                        break;
                    }
                }
            }
            if (x2 - x1 == 1 && y2 - y1 == 1){
                if (!digSetPosition.contains(x1+"_"+y1) || !digSetPosition.contains(x1+"_"+(y1+1)) ||
                        !digSetPosition.contains((x1+1)+"_"+y1) || !digSetPosition.contains((x1+1)+"_"+(y1+1))){
                    matchStatus = false;
                }
            }
            if (matchStatus){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DigArtifacts digArtifacts = new DigArtifacts();
        //System.out.println(digArtifacts.digArtifacts(2, new int[][]{{0,0,0,0},{0,1,1,1}}, new int[][]{{0,0},{0,1}}));
        //System.out.println(digArtifacts.digArtifacts(2, new int[][]{{0,0,0,0},{0,1,1,1}}, new int[][]{{0,0},{0,1},{1,1}}));
        System.out.println(digArtifacts.digArtifacts(6, new int[][]{{0,2,1,5},{0,1,1,1}, {3,0,3,3}, {4,4,4,4}, {2,1,2,4}},
                new int[][]{{0,2},{0,3},{0,4}, {2,0}, {2,1},{2,2}, {2,5}, {3,0}, {3,1}, {3,3}, {3,4},
                        {4,0}, {4,3}, {4,5},{5,0},{5,1}, {5,2}, {5,4}, {5,5}
        }));
    }
}
