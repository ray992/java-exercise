package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountTexts2
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/8 4:25 PM
 * @Version 1.0
 **/
public class CountTexts2 {

    int[] cntMap = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};

    public int countTexts(String pressedKeys) {
        // 相同数字分割+线性dp求出每个相同数字段的情况数
        int len = pressedKeys.length();
        int index = 0;
        List<String> list = new ArrayList<>();
        while (index < len) {
            char ch = pressedKeys.charAt(index);
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            while (index < len - 1 && pressedKeys.charAt(index + 1) == ch) {
                sb.append(pressedKeys.charAt(index + 1));
                index++;
            }
            list.add(sb.toString());
            index++;
        }
        long res = 1;
        for (String s : list) {
            // 这里返回的数字已经位于[0,1e9+7]
            res *= getCount(s);
            // 每当乘一个就取余保证不会溢出
            res %= (int) 1e9 + 7;
        }
        return (int) res;
    }

    // 根据相同数字段计算总的情况数
    private long getCount(String s) {
        int len = s.length();
        if (len == 1) return 1;
        int num = cntMap[s.charAt(0) - '0'];
        // dp[i]表示长度为i的相同数字串情况数
        int[] dp = new int[len + 1];
        dp[0] = 1;  // 这里dp[0]=0为了适应"222"->c的情况
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            // "222"->"a aa","a b","b a","c"
            // 如何理解这几种情况?可以看做前面段长度为j=1-3,后面段长度为len-j
            // 于是就有(1,2),(2,1),(3,0)->1*dp[2]+1*dp[1]+1*dp[0] 注意这里的j组成的都是一个字母a,b,c
            // 因此前面因子都为1,而后面是多少种取决于后面的具体情况数目
            // 因此j的范围为[1,num],这个num是可以为3或4,同时满足i-j>=0保证后面有数字段组合
            for (int j = 1; j <= num && j <= i; j++) {
                dp[i] += dp[i - j];
                dp[i] %= (int) 1e9 + 7;
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        CountTexts2 countTexts = new CountTexts2();
        System.out.println(countTexts.countTexts("222222222222222222222222222222222222"));
    }
}
