package com.exercise.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FirstUniqChar
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/29 下午10:25
 * @Version 1.0
 **/
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        List<Character> noDuplicateList = new ArrayList<>();
        List<Character> exceedOneTimeList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (!noDuplicateList.contains(c)){
                noDuplicateList.add(c);
            }else {
                exceedOneTimeList.add(c);
            }
        }
        Character firstNoDuplicateChar = null;
        for (char c:chars){
            if (noDuplicateList.contains(c) && !exceedOneTimeList.contains(c)){
                firstNoDuplicateChar = c;
                break;
            }
        }
        if (firstNoDuplicateChar == null){
            return  -1;
        }
        int i = 0;
        for (char c:chars){
            if (c == firstNoDuplicateChar){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
