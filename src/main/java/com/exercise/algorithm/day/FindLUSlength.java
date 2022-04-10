package com.exercise.algorithm.day;

public class FindLUSlength {

    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        FindLUSlength findLUSlength = new FindLUSlength();
        System.out.println(findLUSlength.findLUSlength("aaa", "bbb"));
        System.out.println(findLUSlength.findLUSlength("aaa", "aaa"));
    }
}
