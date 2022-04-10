package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName MinimizeResult
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/10 11:15 AM
 * @Version 1.0
 **/
public class MinimizeResult {

    public String minimizeResult(String expression) {
        String[] expressionArray = expression.split("[+]");
        String e1 = expressionArray[0];
        String e2 = expressionArray[1];
        List<String[]> l1 = new ArrayList<>();
        for (int i = 0; i < e1.length(); i++){
            String s1 = e1.substring(0, i);
            String s2 = e1.substring(i);
            l1.add(new String[]{s1, s2});
        }
        List<String[]> l2 = new ArrayList<>();
        for (int i = e2.length(); i > 0; i--){
            String s1 = e2.substring(0, i);
            String s2 = e2.substring(i);
            l2.add(new String[]{s1, s2});
        }
        String ee= null;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < l1.size(); i++){
            for (int j = 0; j < l2.size(); j++){
                String[] ss1 = l1.get(i);
                String[] ss2 = l2.get(j);
                int s1 = Objects.equals(ss1[0], "") ?1:Integer.parseInt(ss1[0]);
                int s2 = Integer.parseInt(ss1[1]);
                int s3 = Integer.parseInt(ss2[0]);
                int s4 = Objects.equals(ss2[1], "") ?1:Integer.parseInt(ss2[1]);
                int curSum = s1*(s2+s3)*s4;
                System.out.println(curSum);
                if (curSum < sum){
                    sum  = curSum;
                    ee = ss1[0] + "(" + ss1[1] + "+" + ss2[0] + ")" + ss2[1];
                }
            }
        }
        return ee;
    }

    public static void main(String[] args) {
        MinimizeResult minimizeResult = new MinimizeResult();
        System.out.println(minimizeResult.minimizeResult("247+38"));
        System.out.println(minimizeResult.minimizeResult("12+34"));
        System.out.println(minimizeResult.minimizeResult("999+999"));
    }
}
