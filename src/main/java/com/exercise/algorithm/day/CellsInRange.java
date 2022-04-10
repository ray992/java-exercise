package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class CellsInRange {

    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(3);
        char c4 = s.charAt(4);
        List<Character> characters = new ArrayList<>();
        characters.add(c1);
        while (true){
            char curChar = (char) (c1 +1);
            if (curChar > c3){
                break;
            }
            characters.add(curChar);
            c1 = curChar;
        }
        List<Character> characters1 = new ArrayList<>();
        characters1.add(c2);
        while (true){
            char curChar = (char) (c2 +1);
            if (curChar > c4){
                break;
            }
            characters1.add(curChar);
            c2 = curChar;
        }
        List<String> res = new ArrayList<>();
        for (Character character:characters){
            for (Character character1:characters1){
                res.add(String.valueOf(character) + String.valueOf(character1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CellsInRange cellsInRange = new CellsInRange();
        System.out.println(cellsInRange.cellsInRange("K1:L2"));
        System.out.println(cellsInRange.cellsInRange("A1:F1"));
    }
}
