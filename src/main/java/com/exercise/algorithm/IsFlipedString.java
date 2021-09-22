package com.exercise.algorithm;

import java.util.Arrays;

/**
 * @ClassName IsFlipedString
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午10:03
 * @Version 1.0
 **/
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if (c1.length != c2.length){
            return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        while (i < c1.length){
            if (c1[i] != c2[i]){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        IsFlipedString isFlipedString = new IsFlipedString();
        System.out.println(isFlipedString.isFlipedString("waterbottle", "erbottlewat"));
    }
}
