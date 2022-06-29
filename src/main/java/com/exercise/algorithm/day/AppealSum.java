package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName AppealSum
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/1 11:02 AM
 * @Version 1.0
 **/
public class AppealSum {

    public long appealSum(String s) {
        List<String> subStringList = new ArrayList<>();
        int n = s.length();
        for (int i = 1 ; i <= n; i++){
            for (int j = 0; j < n; j++){
                if (j + i > n){
                    continue;
                }
                int rightIndex = j + i;
                String subString = s.substring(j, rightIndex);
                subStringList.add(subString);
            }
        }
        long sum = 0;
        for (String subString:subStringList){
            Set<Character> set = new HashSet<>();
            for (char c:subString.toCharArray()){
                set.add(c);
            }
            sum+=set.size();
        }
        return sum;
    }

    public long appealSum2(String s) {
        long sum = 0;
        long ans = 0;
        int[] idx = new int[26];
        for(int i = 0; i < s.length(); i++){
            sum += i - idx[s.charAt(i) - 'a'] + 1;
            ans += sum;
            idx[s.charAt(i) - 'a'] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        AppealSum appealSum = new AppealSum();
        System.out.println(appealSum.appealSum2("abbca"));
        System.out.println(appealSum.appealSum2("code"));
    }
}
