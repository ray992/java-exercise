package com.exercise.algorithm.day;

/**
 * @ClassName IsSubsequence
 * @Description 判断子序列
 * @Author yeqiang
 * @Date 2022/7/4 9:39 AM
 * @Version 1.0
 **/
public class IsSubsequence {

    //双指针
    public boolean isSubsequence2(String s, String t){
        int n1 = s.length();
        int n2 = t.length();
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == n1;
    }


    public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        if (n1 == 0){
            return true;
        }
        int n2 = t.length();
        int start = -1;
        for (int i = 0; i < n1; i++){
            char c = s.charAt(i);
            boolean hit = false;
            for (int j = start+1; j < n2; j++){
                if (c == t.charAt(j)){
                    hit = true;
                    start = j;
                    break;
                }
            }
            if (!hit){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence2("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence2("axc", "ahbgdc"));
    }
}
