package com.exercise.algorithm.day;

/**
 * @ClassName RotateString
 * @Description 旋转字符串匹配
 * @Author yeqiang
 * @Date 2021/11/11 下午9:57
 * @Version 1.0
 **/
public class RotateString {

    public boolean rotateString(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2){
            return false;
        }
        if (n1  == 1){
            return s.equals(goal);
        }
        String origin = s;
        String temp = "";
        while (!temp.equals(s)){
            temp = origin.substring(1) + origin.charAt(0);
            if (temp.equals(goal)) {
                return true;
            }
            origin = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "cdeab"));
        System.out.println(rotateString.rotateString("abcde", "abced"));
    }
}
