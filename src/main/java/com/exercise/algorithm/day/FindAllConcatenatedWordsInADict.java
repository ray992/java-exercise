package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName FindAllConcatenatedWordsInADict
 * @Description 连接词
 * @Author yeqiang
 * @Date 2021/12/28 下午9:13
 * @Version 1.0
 **/
public class FindAllConcatenatedWordsInADict {

    class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> resultList = new ArrayList<>();
        Arrays.sort(words, new MyComparator());
        for (int i = 0; i < words.length; i++){
            int count = 0;

            for (int j = 0; j < i; j++){
                if (words[i].length() == words[j].length()){
                    break;
                }
                if (words[i].contains(words[j])){
                    count++;
                }
                if (count >= 2){
                    resultList.add(words[i]);
                    break;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FindAllConcatenatedWordsInADict findAllConcatenatedWordsInADict = new FindAllConcatenatedWordsInADict();
        System.out.println(findAllConcatenatedWordsInADict.findAllConcatenatedWordsInADict(new String[]{"ab","a","b"}));
    }
}
