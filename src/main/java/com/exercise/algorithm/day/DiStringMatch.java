package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName DiStringMatch
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/9 9:26 AM
 * @Version 1.0
 **/
public class DiStringMatch {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        int min = 0;
        int max = n;
        for (int i = 0; i < n; i++){
            char curChar = s.charAt(i);
            if (curChar == 'I'){
                res[i] = min;
                min++;
            }else if (curChar == 'D'){
                res[i] = max;
                max--;
            }
        }
        char lastChar = s.charAt(n - 1);
        if (lastChar == 'I'){
            res[n] = res[n - 1]+1;
        }else {
            res[n] = res[n - 1] - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        DiStringMatch diStringMatch = new DiStringMatch();
        System.out.println(Arrays.toString(diStringMatch.diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch.diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch.diStringMatch("DDI")));
    }
}
