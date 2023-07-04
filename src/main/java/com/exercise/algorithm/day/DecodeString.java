package com.exercise.algorithm.day;

import org.apache.commons.collections.ArrayStack;

import java.util.*;

/**
 * @ClassName DecodeString
 * @Description 字符串解码
 * @Author yeqiang
 * @Date 2022/7/8 9:45 AM
 * @Version 1.0
 **/
public class DecodeString {

    public String decodeString(String s) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < 26; i++){
            characters.add((char) ('a' + i));
        }
        Deque<Character> expression = new ArrayDeque<>();
        int sn = s.length();
        for (int i = 0; i < sn; i++){
            char cc = s.charAt(i);
            if (cc == ']'){
                StringBuilder stringBuilder = new StringBuilder();
                int ss = 0;
                while (!expression.isEmpty()){
                    char popChar = expression.pollLast();
                    if (popChar == '['){
                        ss++;
                    }
                    if (ss > 1 || (ss == 1 && characters.contains(popChar))){
                        expression.offer(popChar);
                        break;
                    }
                    if (popChar != '['){
                       stringBuilder.append(popChar);
                    }
                }
                String childExpression = stringBuilder.reverse().toString();
                int startCharIndex = 0;
                for (int r = 0; r < childExpression.length(); r++){
                    if (characters.contains(childExpression.charAt(r))){
                        startCharIndex = r;
                        break;
                    }
                }
                int num = Integer.parseInt(childExpression.substring(0, startCharIndex));
                String copyString = childExpression.substring(startCharIndex);
                String deCoding = "";
                for (int m = 0; m < num; m++){
                    deCoding = deCoding.concat(copyString);
                }
                for (int n = 0; n < deCoding.length(); n++){
                    expression.add(deCoding.charAt(n));
                }
            }else {
                expression.offerLast(cc);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!expression.isEmpty()){
            stringBuilder.append(expression.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        //System.out.println(decodeString.decodeString("3[a]2[bc]"));
        //System.out.println(decodeString.decodeString("3[a2[c]]"));
        //System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        //System.out.println(decodeString.decodeString("abc3[cd]xyz"));
        System.out.println(decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
