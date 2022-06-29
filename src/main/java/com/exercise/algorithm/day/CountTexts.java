package com.exercise.algorithm.day;

/**
 * @ClassName CountTexts
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/8 4:05 PM
 * @Version 1.0
 **/
public class CountTexts {

    static final int N = 100010;
    static long[] three = new long[N];
    static long[] four = new long[N];

    static int MOD = (int) 1e9 + 7;

    static {
        three[0] = 1;
        three[1] = 1;
        three[2] = 2;
        three[3] = 4;

        four[0] = 1;
        four[1] = 1;
        four[2] = 2;
        four[3] = 4;


        for (int i = 4; i < N; i++){
            three[i] = three[i - 1] = three[i - 2] + three[i - 3];
            three[i] %= MOD;
            four[i] = four[i - 1] + four[i - 2] + four[i - 3] + four[i - 4];
            four[i] %= MOD;
        }
    }

    public int countTexts(String pressedKeys) {
        char[] cs = pressedKeys.toCharArray();
        int i = 0;
        int n = cs.length;
        long ans = 1;
        while (i < n){
            int j = i;
            while (j + 1 < n && cs[j] == cs[j+1]){
                j++;
            }
            boolean isFour = cs[i] == '7' ||  cs[i] == '9';
            long cur = isFour ? four[j - i + 1]:three[j - i + 1];
            ans = (ans * cur) % MOD;
            i = j + 1;
        }
        return (int) ans;
    }

    public int countTexts2(String pressedKeys) {
        char[] cs = pressedKeys.toCharArray();
        int n = cs.length, i = 0;
        long ans = 1;
        while (i < n) {
            int j = i;
            while (j + 1 < n && cs[j] == cs[j + 1]) j++;
            boolean isFour = cs[i] == '7' || cs[i] == '9';
            long cur = isFour ? four[j - i + 1] : three[j - i + 1];
            ans = (ans * cur) % MOD;
            i = j + 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts2("22233"));
    }
}
