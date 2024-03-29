package com.exercise.algorithm.day;

public class FindKthNumber {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindKthNumber findKthNumber = new FindKthNumber();
        System.out.println(findKthNumber.findKthNumber(3,3,6));
    }
}
