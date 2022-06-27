package com.exercise.algorithm.day;

public class MinDeletionSize {

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int l = strs[0].length();
        int i = 0;
        int removeCount = 0;
        while (i < l){
            char preChar = strs[0].charAt(i);
            for (int r = 1; r < n; r++){
                char curChar = strs[r].charAt(i);
                if (curChar < preChar){
                    removeCount++;
                    break;
                }
                preChar = curChar;
            }
            i++;
        }
        return removeCount;
    }

    public static void main(String[] args) {
        MinDeletionSize minDeletionSize = new MinDeletionSize();
        //System.out.println(minDeletionSize.minDeletionSize(new String[]{"abc", "bce", "cae"}));
        //System.out.println(minDeletionSize.minDeletionSize(new String[]{"a","b"}));
        //System.out.println(minDeletionSize.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(minDeletionSize.minDeletionSize(new String[]{"rrjk","furt","guzm"}));
    }
}
