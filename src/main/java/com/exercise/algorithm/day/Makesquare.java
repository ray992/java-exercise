package com.exercise.algorithm.day;

import java.util.Arrays;

public class Makesquare {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int num : matchsticks) sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        return allocate(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    private boolean allocate(int[] nums, int pos, int[] sums, int avg) {
        if (pos == -1)
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + nums[pos] > avg) continue;
            sums[i] += nums[pos];
            if (allocate(nums, pos - 1, sums, avg))
                return true;
            sums[i] -= nums[pos];
        }
        return false;
    }
}
