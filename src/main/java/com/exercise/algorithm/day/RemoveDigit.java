package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName RemoveDigit
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/1 10:30 AM
 * @Version 1.0
 **/
public class RemoveDigit {

    public String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        List<Integer> indexList = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--){
            if (number.charAt(i) == digit){
                indexList.add(i);
            }
        }
        List<String> numberString = new ArrayList<>();
        for (int i = 0; i < indexList.size(); i++){
            String subString = number.substring(0, indexList.get(i)) + number.substring(indexList.get(i)+1);
            numberString.add(subString);
        }
        Collections.sort(numberString);
        return numberString.get(numberString.size() - 1);
    }


}
