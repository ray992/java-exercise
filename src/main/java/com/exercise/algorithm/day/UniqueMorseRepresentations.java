package com.exercise.algorithm.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UniqueMorseRepresentations
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/10 10:12 AM
 * @Version 1.0
 **/
public class UniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        String[] dic = new String[]{
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Map<Character, String> characterStringMap = new HashMap<>();
        for (int i = 0; i < 26; i++){
            characterStringMap.put((char) ('a'+i), dic[i]);
        }
        Set<String> representSet = new HashSet<>();
        for (String word:words){
            StringBuilder stringBuilder = new StringBuilder();
            for (char c:word.toCharArray()){
                stringBuilder.append(characterStringMap.get(c));
            }
            representSet.add(stringBuilder.toString());
        }
        return representSet.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
