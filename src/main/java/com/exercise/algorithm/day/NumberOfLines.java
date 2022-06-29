package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName NumberOfLines
 * @Description 写字符串需要的行数
 * @Author yeqiang
 * @Date 2022/4/12 9:37 AM
 * @Version 1.0
 **/
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String s) {
        int row = 1;
        int remainWidth = 100;
        for (char c:s.toCharArray()){
            int width = widths[c-'a'];
            if (remainWidth - width < 0) {
                row++;
                remainWidth = 100;
            }
            remainWidth = remainWidth - width;
        }
        return new int[]{row, 100-remainWidth};
    }

    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();
        System.out.println(Arrays.toString(numberOfLines.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(numberOfLines.numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa")));
    }
}
