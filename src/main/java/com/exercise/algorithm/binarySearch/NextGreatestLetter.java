package com.exercise.algorithm.binarySearch;

/**
 * @ClassName NextGreatestLetter
 * @Description 寻找比目标字母大的最小字母
 * @Author yeqiang
 * @Date 2022/6/29 10:01 PM
 * @Version 1.0
 **/
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int middle = (right - left) / 2 + left;
            char curChar = letters[middle];
            if (curChar > target){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        if (right + 1 >= n){
            return letters[0];
        }
        return letters[right + 1];
    }

    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
}
