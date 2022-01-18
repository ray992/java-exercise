package com.exercise.algorithm.day;

/**
 * @ClassName CountVowelPermutation
 * @Description 统计元音字母序列的数目
 * @Author yeqiang
 * @Date 2022/1/17 上午10:33
 * @Version 1.0
 **/
public class CountVowelPermutation {

    private static final long MOD = (long)1e9 + 7;

    public int countVowelPermutation(int n) {
        long a, e, i, o, u;
        a = e = i = o = u = 1;
        while(--n>0){
            long an, en, in, on, un;
            an = e;
            en = (a + i) % MOD;
            in = ((((a + e) % MOD + o) % MOD) + u) % MOD;
            on = (i + u) % MOD;
            un = a;
            a = an;
            e = en;
            i = in;
            o = on;
            u = un;
        }
        return (int)((((((a + e) % MOD + i) % MOD + o) % MOD) + u) % MOD);
    }

    public static void main(String[] args) {
        CountVowelPermutation countVowelPermutation = new CountVowelPermutation();
        System.out.println(countVowelPermutation.countVowelPermutation(10));
    }
}
