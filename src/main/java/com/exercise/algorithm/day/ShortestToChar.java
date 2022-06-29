package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ShortestToChar
 * @Description 字符的最大距离
 * @Author yeqiang
 * @Date 2022/4/19 9:45 AM
 * @Version 1.0
 **/
public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                indexList.add(i);
            }
        }
        int indexSize = indexList.size();
        int[] answer = new int[s.length()];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < indexSize; j++){
                int p1 = indexList.get(j);
                answer[i] = Math.min(answer[i], Math.abs(i - p1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        System.out.println(Arrays.toString(shortestToChar.shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(shortestToChar.shortestToChar("aaab", 'b')));
    }
}
