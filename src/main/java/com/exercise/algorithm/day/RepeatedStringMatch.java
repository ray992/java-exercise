package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RepeatedStringMatch
 * @Description 重复叠加字符串匹配
 * @Author yeqiang
 * @Date 2021/12/22 上午9:50
 * @Version 1.0
 **/
public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
         Set<Character> visited = new HashSet<>();
         for (int i = 0; i < b.length(); i++){
             char c1 = b.charAt(i);
             boolean match = false;
             if (visited.contains(c1)){
                 continue;
             }
             for (int j = 0; j < a.length(); j++){
                 char c2 = a.charAt(j);
                 if (c1 == c2){
                     visited.add(c2);
                     match = true;
                     break;
                 }
             }
             if (!match){
                 return -1;
             }
         }
         int count = 1;
         String origin = a;
         while (!a.contains(b)){
             if (a.length() >= 10 * b.length()){
                 count = -1;
                 break;
             }
             a = a.concat(origin);
             count++;
         }
         return count;
    }

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        /*System.out.println(repeatedStringMatch.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("a", "a"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abc", "wsx"));
        System.out.println(repeatedStringMatch.repeatedStringMatch("abc", "ba"));*/
        System.out.println(repeatedStringMatch.repeatedStringMatch("abc", "cabcabca"));
    }
}
