package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountValidWords2
 * @Description  句子中的有效单词数
 * @Author yeqiang
 * @Date 2022/1/27 下午4:44
 * @Version 1.0
 **/
public class CountValidWords2 {

    public int countValidWords(String sentence) {
        int validWordCount = 0;
        List<Character> validCharacterWordList = new ArrayList<>();
        char c1 = 'a';
        for (int i = 0; i < 26; i++){
            char cc = (char) (c1 + i);
            validCharacterWordList.add(cc);
        }
        List<Character> validNumberWordList = new ArrayList<>();
        char c2 = '1';
        for (int i = 0; i < 9; i++){
            char cc = (char) (c2 + i);
            validNumberWordList.add(cc);
        }
        String[] sentenceArray = sentence.split("[ ]");
        for (String curWord:sentenceArray){
            curWord = curWord.trim();
            if (curWord.equals("")){
                continue;
            }
            int connectCharCount = 0;
            int tagCharCount = 0;
            int s1 = 0, s2 = 0;
            boolean validStatus = true;
            int length = curWord.length();
            for (int i = 0; i < length; i++){
                char curChar = curWord.charAt(i);
                if (curChar == '!' || curChar == '.' || curChar == ','){
                    tagCharCount++;
                    continue;
                }
                if (curChar == '-'){
                    connectCharCount++;
                    s1 = i - 1;
                    s2 = i + 1;
                    continue;
                }
                if (validNumberWordList.contains(curChar)){
                    validStatus = false;
                    break;
                }
                if (!validCharacterWordList.contains(curChar)){
                    validStatus = false;
                    break;
                }
            }
            if (connectCharCount  > 1){
                validStatus = false;
            }
            if (tagCharCount > 1){
                validStatus = false;
            }
            if (validStatus){
                boolean matchStatus = true;
                if (connectCharCount == 1){
                    if (s1 < 0 || s2 > length - 1 || !validCharacterWordList.contains(curWord.charAt(s1)) || !validCharacterWordList.contains(curWord.charAt(s2))){
                        matchStatus = false;
                    }
                }
                if (tagCharCount == 1){
                    char lastChar = curWord.charAt(length - 1);
                    if (lastChar != '!' && lastChar != '.' && lastChar != ','){
                        matchStatus = false;
                    }
                }
                if (matchStatus){
                    validWordCount++;
                }
            }
        }
        return validWordCount;
    }

    public static void main(String[] args) {
        CountValidWords2 countValidWords2 = new CountValidWords2();
        System.out.println(countValidWords2.countValidWords("cat and  dog"));
        System.out.println(countValidWords2.countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords2.countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(countValidWords2.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }
}
