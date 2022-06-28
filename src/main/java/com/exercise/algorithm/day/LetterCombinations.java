package com.exercise.algorithm.day;

import java.util.*;


public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();

        Map<Character, List<Character>> numberCharacterMap = new HashMap<>();
        List<Character> character2KeyList = new ArrayList<>();
        char c = 'a';
        int i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character2KeyList.add(c);
        }
        numberCharacterMap.put('2', character2KeyList);
        List<Character> character3KeyList = new ArrayList<>();
        i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character3KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('3', character3KeyList);

        List<Character> character4KeyList = new ArrayList<>();
        i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character4KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('4', character4KeyList);

        List<Character> character5KeyList = new ArrayList<>();
        i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character5KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('5', character5KeyList);

        List<Character> character6KeyList = new ArrayList<>();
        i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character6KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('6', character6KeyList);

        List<Character> character7KeyList = new ArrayList<>();
        i = 0;
        for (; i < 4; i++){
            c = (char) (c + i);
            character7KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('7', character7KeyList);

        List<Character> character8KeyList = new ArrayList<>();
        i = 0;
        for (; i < 3; i++){
            c = (char) (c + i);
            character8KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('8', character8KeyList);

        List<Character> character9KeyList = new ArrayList<>();
        i = 0;
        for (; i < 4; i++){
            c = (char) (c + i);
            character9KeyList.add((char) (c + i));
        }
        numberCharacterMap.put('9', character9KeyList);
        Deque<String> deque = new ArrayDeque<>();
        char cc0 = digits.charAt(0);
        List<Character> cc0List = numberCharacterMap.get(cc0);
        for (Character character:cc0List){
            deque.addLast(String.valueOf(character));
        }
        int m = 1;
        while (!deque.isEmpty()){
            int size = deque.size();

        }
        return null;
    }
}
