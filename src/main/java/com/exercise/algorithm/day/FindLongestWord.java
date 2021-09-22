package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindLongestWord
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/14 上午9:05
 * @Version 1.0
 **/
public class FindLongestWord {

    public String findLongestWord(String s, List<String> dictionary) {
        TreeSet<String> answerSet = new TreeSet<>();
        Map<Character, ArrayList<Integer>> characterPositionMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char _c = chars[i];
            if (characterPositionMap.containsKey(_c)){
                characterPositionMap.get(_c).add(i);
            }else {
                ArrayList<Integer> indexList = new ArrayList();
                indexList.add(i);
                characterPositionMap.put(_c, indexList);
            }
        }
        Deque<Integer> existList = new LinkedList<>();
        int minLength = Integer.MIN_VALUE;
        for (String dic:dictionary){
           char[] chars1 = dic.toCharArray();
           boolean completeStatus = true;
           for (char c:chars1){
               if (!characterPositionMap.containsKey(c)){
                   completeStatus = false;
                   break;
               }
               List<Integer> indexList = characterPositionMap.get(c);
               boolean hitStatus = false;
               for (int index:indexList){
                   if (existList.contains(index) || (!existList.isEmpty() && existList.peekLast() > index )){
                       continue;
                   }else {
                       existList.addLast(index);
                       hitStatus = true;
                       break;
                   }
               }
               if (!hitStatus){
                   completeStatus = false;
                   break;
               }
           }
           existList.clear();
           if (completeStatus){
               if(dic.length() == minLength){
                   answerSet.add(dic);
               }else if (dic.length() > minLength){
                   answerSet.clear();
                   answerSet.add(dic);
                   minLength = dic.length();
               }
           }
        }
        return answerSet.isEmpty()?"":answerSet.pollFirst();
    }


    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        ArrayList<String> dicList = new ArrayList<String>();
        dicList.add("ale");
        dicList.add("apple");
        dicList.add("monkey");
        dicList.add("plea");
        System.out.println(findLongestWord.findLongestWord("abpcplea", dicList));
      /*  dicList.add("b");
        dicList.add("a");
        dicList.add("c");
        dicList.add("b");
        System.out.println(findLongestWord.findLongestWord("abpcplea", dicList));*/
    }
}
