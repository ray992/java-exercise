package com.exercise.algorithm;

/**
 * @ClassName CompressString
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午9:51
 * @Version 1.0
 **/
public class CompressString {

    public String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.toCharArray();
        char tempChar = ' ';
        int count = 0;
        for (char c:chars){
            if (tempChar == ' '){
                tempChar = c;
                count = 1;
            }else if (c == tempChar){
                count++;
            }else {
                stringBuilder.append(tempChar).append(count);
                tempChar = c;
                count = 1;
            }
        }
        stringBuilder.append(tempChar).append(count);
        return stringBuilder.toString().length() >= S.length() ? S:stringBuilder.toString();
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        System.out.println(compressString.compressString("aabcccccaaa"));
        System.out.println(compressString.compressString("abbccd"));
        System.out.println(compressString.compressString("bb"));
    }
}
