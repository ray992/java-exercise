package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindWords
 * @Description 键盘行
 * @Author yeqiang
 * @Date 2021/10/31 下午11:54
 * @Version 1.0
 **/
public class FindWords {

    String firstRowChar = "qwertyuiop";
    String secondRowChar = "asdfghjkl";
    String thirdRowChar = "zxcvbnm";

    public String[] findWords(String[] words) {
        Set<Character> firstRowCharSet = new HashSet<>();
        for (char c:firstRowChar.toCharArray()){
            firstRowCharSet.add(c);
        }
        Set<Character> secondRowCharSet = new HashSet<>();
        for (char c:secondRowChar.toCharArray()){
            secondRowCharSet.add(c);
        }
        Set<Character> thirdRowCharSet = new HashSet<>();
        for (char c:thirdRowChar.toCharArray()){
            thirdRowCharSet.add(c);
        }
        List<String> validWordList = new ArrayList<>();
        for (String s:words){
           char[] chars = s.toLowerCase().toCharArray();
           char firstChar = chars[0];
           int type = 0;
           if (firstRowCharSet.contains(firstChar)){
               type = 1;
           }else if (secondRowCharSet.contains(firstChar)){
               type = 2;
           }else if (thirdRowCharSet.contains(firstChar)){
               type = 3;
           }
           if (type == 0){
               continue;
           }
           if (chars.length == 1){
               validWordList.add(s);
               continue;
           }
           boolean validStatus = true;
           for (int i = 1; i < chars.length; i++){
              if ((type == 1 && !firstRowCharSet.contains(chars[i])) || (type == 2 && !secondRowCharSet.contains(chars[i])) || (type == 3 && !thirdRowCharSet.contains(chars[i]))){
                  validStatus = false;
                  break;
              }
           }
           if (validStatus){
               validWordList.add(s);
           }
        }
        String[] res = new String[validWordList.size()];
        return validWordList.toArray(res);
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        System.out.println(Arrays.toString(findWords.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(findWords.findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(findWords.findWords(new String[]{"adsdf","sfd"})));
    }
}
