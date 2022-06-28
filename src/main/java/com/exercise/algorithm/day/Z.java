package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName Z
 * @Description z型变幻
 * @Author yeqiang
 * @Date 2021/3/1 9:17 下午
 * @Version 1.0
 **/
public class Z {

    public static String convert(String s, int numRows){
        if (numRows == 1){
            return s;
        }
        StringBuilder[] a = new StringBuilder[Math.min(s.length(), numRows)];
        int curRow =  1;
        int step = -1;
        for (char c:s.toCharArray()){
            StringBuilder curString = a[curRow-1];
            if (curString == null){
                curString = new StringBuilder();
            }
            a[curRow - 1] = curString.append(c);
            if (curRow == 1 || curRow == numRows) {
                step = -step;
            }
            curRow = curRow + step;
        }
        StringBuilder stringBuilder_ = new StringBuilder();
        for (StringBuilder ss:a){
            stringBuilder_.append(ss);
        }
        return stringBuilder_.toString();
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(10, -1));
    }
}
