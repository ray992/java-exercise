package com.exercise.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName RemoveDuplicates
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/9 9:12 下午
 * @Version 1.0
 **/
public class RemoveDuplicates {

    public static String[] alphabet = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};

    public static String removeDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        while (true){
           for (int i = 0; i < alphabet.length; i++){
               s = s.replace(alphabet[i], "");
           }
           char[] chars =  s.toCharArray();
           for (char c:chars){
               set.add(c);
           }
           if (set.size() == chars.length){
               break;
           }
           set.clear();
       }
       return s;
    }

    public static String removeDuplicates1(String S){
        String result = "";
        while (true){
            int i = 0;
            char[] chars = S.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            while (i < chars.length){
                if (i == chars.length - 1){
                    stringBuilder.append(chars[i]);
                    break;
                }
                if (chars[i] == chars[i+1]){
                    i = i +2;
                }else {
                    stringBuilder.append(chars[i]);
                    i++;
                }
            }
            S = stringBuilder.toString();
            if (S.length() == chars.length){
                result = S;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates1("aaaaaaaaa"));

    }
}
