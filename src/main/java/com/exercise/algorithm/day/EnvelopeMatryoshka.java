package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName EnvelopeMatryoshka
 * @Description 信封套娃问题
 * @Author yeqiang
 * @Date 2021/3/4 8:38 下午
 * @Version 1.0
 **/
public class EnvelopeMatryoshka {

    static boolean check(int[][] es, int mid, int i) {
        return es[mid][0] < es[i][0] && es[mid][1] < es[i][1];
    }

    public static int maxEnvelopes(int[][] es) {
        int n = es.length;
        if (n == 0) return n;
        // 因为我们在找第 i 件物品的前一件物品时，会对前面的 i - 1 件物品都遍历一遍，因此第二维（高度）排序与否都不影响
        Arrays.sort(es, (a, b)->a[0]-b[0]);
        int[] f = new int[n]; // f(i) 为考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int ans = 1;
        for (int i = 0; i < n; i++) {
            // 对于每个 f[i] 都满足最小值为 1
            f[i] = 1;
            // 枚举第 i 件物品的前一件物品，
            for (int j = i - 1; j >= 0; j--) {
                // 只要有满足条件的前一件物品，我们就尝试使用 f[j] + 1 更新 f[i]
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            // 在所有的 f[i] 中取 max 作为 ans
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] es = new int[4][2];
        int[] temp = {5,4};
        es[0] = temp;
        temp = new int[]{6,4};
        es[1] = temp;
        temp = new int[]{6,7};
        es[2] = temp;
        temp = new int[]{2,3};
        es[3] = temp;
        System.out.println(maxEnvelopes(es));
    }
}
