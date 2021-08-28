package com.exercise.algorithm.day;

/**
 * @ClassName LongestPalindromeSubseq
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/12 上午9:12
 * @Version 1.0
 **/
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    public String longestPalindrome(String s) {
        return "";
    }
}
