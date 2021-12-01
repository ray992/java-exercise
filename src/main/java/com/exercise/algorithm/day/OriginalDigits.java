package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName OriginalDigits
 * @Description 从英文重建数字
 * @Author yeqiang
 * @Date 2021/11/24 上午9:30
 * @Version 1.0
 **/
public class OriginalDigits {

    Map<String, Integer> numbers = new LinkedHashMap<>();

    {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
    }

    public String originalDigits(String s) {
       List<String> inputList = new ArrayList<>();
       while (!s.equals("")){
           if (s.contains("z") && s.contains("e") && s.contains("r") && s.contains("o")){
               s = s.replaceFirst("z", "").replaceFirst("e", "").replaceFirst("r", "").replaceFirst("o", "");
               inputList.add("zero");
           }
           if (s.contains("o") && s.contains("n") && s.contains("e")){
               s = s.replaceFirst("o", "").replaceFirst("n", "").replaceFirst("e", "");
               inputList.add("one");
           }
           if (s.contains("t") && s.contains("w") && s.contains("o")){
               s = s.replaceFirst("t", "").replaceFirst("w", "").replaceFirst("o", "");
               inputList.add("two");
           }
           if (s.contains("t") && s.contains("h") && s.contains("r") && s.contains("e")){
               s = s.replaceFirst("t", "").replaceFirst("h", "").replaceFirst("r", "").replaceFirst("e", "").replaceFirst("e", "");
               inputList.add("three");
           }
           if (s.contains("f") && s.contains("o") && s.contains("u") && s.contains("r")){
               s = s.replaceFirst("f", "").replaceFirst("o", "").replaceFirst("u", "").replaceFirst("r", "");
               inputList.add("four");
           }
           if (s.contains("f") && s.contains("i") && s.contains("v") && s.contains("e")){
               s = s.replaceFirst("f", "").replaceFirst("i", "").replaceFirst("v", "").replaceFirst("e", "");
               inputList.add("five");
           }
           if (s.contains("s") && s.contains("i") && s.contains("x") ){
               s = s.replaceFirst("s", "").replaceFirst("i", "").replaceFirst("x", "");
               inputList.add("six");
           }
           if (s.contains("s") && s.contains("e") && s.contains("v") && s.contains("e")&& s.contains("n")  ){
               s = s.replaceFirst("s", "").replaceFirst("e", "").replaceFirst("v", "").replaceFirst("e", "").replaceFirst("n", "");
               inputList.add("seven");
           }
           if (s.contains("e") && s.contains("i") && s.contains("g") && s.contains("h")&& s.contains("t")  ){
               s = s.replaceFirst("e", "").replaceFirst("i", "").replaceFirst("g", "").replaceFirst("h", "").replaceFirst("t", "");
               inputList.add("eight");
           }
           if (s.contains("n") && s.contains("i") && s.contains("n") && s.contains("e") ){
               s = s.replaceFirst("n", "").replaceFirst("i", "").replaceFirst("n", "").replaceFirst("e", "");
               inputList.add("nine");
           }
       }

        if (inputList.size() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String key:inputList){
            result.append(numbers.get(key));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        OriginalDigits originalDigits = new OriginalDigits();
        System.out.println(originalDigits.originalDigits("owoztneoer"));
        System.out.println(originalDigits.originalDigits("fviefuro"));
        System.out.println(originalDigits.originalDigits("zerozero"));
    }
}
