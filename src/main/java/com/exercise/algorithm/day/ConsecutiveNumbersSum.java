package com.exercise.algorithm.day;

/**
 * @ClassName ConsecutiveNumbersSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/5 10:54 AM
 * @Version 1.0
 **/
public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        int bound = 2 * n;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }
}
