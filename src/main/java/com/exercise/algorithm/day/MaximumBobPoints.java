package com.exercise.algorithm.day;


import java.util.Arrays;

public class MaximumBobPoints {

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = 12;

        int[] ans = new int[n];
        int maxScore = -1;
        for (int i = 0; i < 1 << n; i++) {
            // 二进制枚举
            int score = 0;
            int arrows = 0;
            int[] bobArrows = new int[n];
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    score += j;
                    // 获胜只多射一支箭
                    arrows += aliceArrows[j] + 1;
                    // 记录
                    bobArrows[j] = aliceArrows[j] + 1;
                }
            }

            if (arrows > numArrows) {
                // 超出箭数量限制，不合法
                continue;
            }

            if (score > maxScore) {
                maxScore = score;
                bobArrows[0] += numArrows - arrows;
                ans = bobArrows;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        MaximumBobPoints maximumBobPoints = new MaximumBobPoints();
        System.out.println(Arrays.toString(maximumBobPoints.maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2})));
    }
}
