package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestSubsequence
 * @Description 最长定差子序列
 * @Author yeqiang
 * @Date 2021/11/5 上午9:27
 * @Version 1.0
 **/
public class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        System.out.println(longestSubsequence.longestSubsequence(new int[]{1,3,5,7,10}, 2));
    }
}
