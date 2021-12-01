package com.exercise.algorithm.day;

/**
 * @ClassName FindNthDigit
 * @Description 第N位数字
 * @Author yeqiang
 * @Date 2021/11/30 上午9:44
 * @Version 1.0
 **/
public class FindNthDigit {

    public int findNthDigit(int n) {
        int cur = 0;
        int start = 0;
        int curLength = 0;
        String curString = "";
        do {
            start++;
            curString = (start + "");
            curLength = curString.length();
            cur = cur + curLength;
        } while (cur < n);
        int diff = cur - n;
        char curChar = curString.charAt(curLength - diff - 1);
        return Integer.parseInt(new String(new char[]{curChar}));
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(3));
        System.out.println(findNthDigit.findNthDigit(11));
    }
}
