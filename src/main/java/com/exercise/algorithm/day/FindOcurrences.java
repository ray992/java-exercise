package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindOcurrences
 * @Description Bigram 分词
 * @Author yeqiang
 * @Date 2021/12/26 下午5:15
 * @Version 1.0
 **/
public class FindOcurrences {

    public String[] findOcurrences(String text, String first, String second) {
        String[] originText = text.split("[ ]");
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < originText.length; i++){
            if (i >= 2 && originText[i-2].equals(first) && originText[i-1].equals(second)){
                resultList.add(originText[i]);
            }
        }
        String[] resultArray = new String[resultList.size()];
        return resultList.toArray(resultArray);
    }

    public static void main(String[] args) {
        FindOcurrences findOcurrences = new FindOcurrences();
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("we will we will rock you", "we", "will")));
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa", "kcyxdfnoa", "jkypmsxd")));
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("we we we we will rock you", "we", "we")));
        //"jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa"
        //"kcyxdfnoa"
        //"jkypmsxd"
        //"we we we we will rock you"
        //"we"
        //"we"
    }
}
