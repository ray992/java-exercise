package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CountValidWords
 * @Description 句子中的有效单词数
 * @Author yeqiang
 * @Date 2021/10/24 上午10:34
 * @Version 1.0
 **/
public class CountValidWords {

    private static final char[] lowerCharacterArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
    ,'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final char[] tagArray = {'!', '.', ','};

    public int countValidWords(String sentence) {
        List<Character> validCharacterList = new ArrayList<>();
        List<Character> pureCharacterList = new ArrayList<>();
        List<Character> tagCharacterList = new ArrayList<>();
        for (char c:lowerCharacterArray){
            validCharacterList.add(c);
            pureCharacterList.add(c);
        }
        for (char c:tagArray){
            validCharacterList.add(c);
            tagCharacterList.add(c);
        }
        validCharacterList.add('-');
        String[] tokens = sentence.split("[ ]");
        int resCount = 0;
        for (String token:tokens){
            char pre = '~';
            int linkCharCount = 0;
            int tagCharCount = 0;
            boolean validStatus = true;
            String pureToken = token.trim();
            if (pureToken.equals("")){
                continue;
            }
            for (int i = 0; i < pureToken.length(); i++){
                if (!validCharacterList.contains(pureToken.charAt(i))){
                    validStatus = false;
                    break;
                }
                if (pureToken.charAt(i) == '-'){
                    linkCharCount++;
                    if (linkCharCount > 1){
                        validStatus = false;
                        break;
                    }
                    if (!pureCharacterList.contains(pre)){
                        validStatus = false;
                        break;
                    }
                    if ((i+1) > (pureToken.length() -1) || !pureCharacterList.contains(pureToken.charAt(i+1))){
                        validStatus = false;
                        break;
                    }
                }
                if (tagCharacterList.contains(pureToken.charAt(i))){
                    tagCharCount++;
                    if(tagCharCount > 1){
                        validStatus = false;
                        break;
                    }
                    if (i != pureToken.length() - 1){
                        validStatus = false;
                        break;
                    }
                }
                pre = pureToken.charAt(i);
            }
            if (validStatus){
                resCount++;
            }
        }
        return resCount;
    }

    public static void main(String[] args) {
        CountValidWords countValidWords = new CountValidWords();
        System.out.println(countValidWords.countValidWords("cat and  dog"));
        System.out.println(countValidWords.countValidWords("!this  1-s b8d!"));
        System.out.println(countValidWords.countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(countValidWords.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }
}
