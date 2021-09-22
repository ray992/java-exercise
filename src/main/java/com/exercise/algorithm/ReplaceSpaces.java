package com.exercise.algorithm;

/**
 * @ClassName ReplaceSpaces
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/7 下午9:47
 * @Version 1.0
 **/
public class ReplaceSpaces {

    public String replaceSpaces(String S, int length) {
       S = S.substring(0,length);
       return S.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        ReplaceSpaces replaceSpaces = new ReplaceSpaces();
        System.out.println(replaceSpaces.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces.replaceSpaces("                   ", 5));
    }
}
