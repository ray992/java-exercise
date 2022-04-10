package com.exercise.algorithm.day;


import java.util.HashSet;
import java.util.Set;

public class NearestPalindromic {

    public String nearestPalindromic(String s){
        int n = s.length();
        long cur = Long.parseLong(s);
        Set<Long> set = new HashSet<>();
        set.add((long) Math.pow(10, n - 1) - 1);
        set.add((long) Math.pow(10, n) + 1);
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));
        for (long i = t - 1; i <= t + 1; i++) {
            long temp = -1;
            if (n % 2 == 0) temp = getNum(i, true);
            else temp = getNum(i, false);
            if (temp != cur) set.add(temp);
        }
        long ans = -1;
        for (long i : set) {
            if (ans == -1) ans = i;
            else if (Math.abs(i - cur) < Math.abs(ans - cur)) ans = i;
            else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) ans = i;
        }
        return String.valueOf(ans);
    }

    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0) sb.append(sb.charAt(idx--));
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        NearestPalindromic nearestPalindromic = new NearestPalindromic();
        System.out.println(nearestPalindromic.nearestPalindromic("123"));
    }
}
