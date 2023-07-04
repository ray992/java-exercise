package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName BackspaceCompare
 * @Description 比较含退格的字符串
 * @Author yeqiang
 * @Date 2022/7/8 9:19 AM
 * @Version 1.0
 **/
public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        Deque<Character> sd = new ArrayDeque<>();
        for (int i = 0; i < sn; i++){
            if (s.charAt(i) != '#'){
                sd.addLast(s.charAt(i));
            }else {
                sd.pollLast();
            }
        }
        Deque<Character> td = new ArrayDeque<>();
        for (int i = 0; i < tn; i++){
            if (t.charAt(i) != '#'){
                td.addLast(t.charAt(i));
            }else {
                td.pollLast();
            }
        }
        while (!sd.isEmpty() || !td.isEmpty()){
           Character c1 =  sd.pollLast();
           Character c2 = td.pollLast();
           if (c1 == null || c2 == null){
               return false;
           }
           if (c1 != c2){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
