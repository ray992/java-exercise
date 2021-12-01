package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName BuddyStrings
 * @Description 亲密字符串
 * @Author yeqiang
 * @Date 2021/11/23 上午9:51
 * @Version 1.0
 **/
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2){
            return false;
        }
        Set<Character> noDuplicateCharacterSet = new HashSet<>();
        List<Integer> noEqualsPositionList = new ArrayList<>();
        for (int i = 0; i < n1; i++){
            if (s.charAt(i) != goal.charAt(i)){
                noEqualsPositionList.add(i);
            }
            noDuplicateCharacterSet.add(s.charAt(i));
            if (noEqualsPositionList.size() > 2){
                return false;
            }
        }
        if (noEqualsPositionList.size() == 0){
            return noDuplicateCharacterSet.size() != s.length();
        }
        if (noEqualsPositionList.size() == 1){
            return false;
        }
        int t1 = noEqualsPositionList.get(0);
        int t2 = noEqualsPositionList.get(1);
        return s.charAt(t1) == goal.charAt(t2) && s.charAt(t2) == goal.charAt(t1);
    }

    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.buddyStrings("ab", "ba"));
        System.out.println(buddyStrings.buddyStrings("ab", "ab"));
        System.out.println(buddyStrings.buddyStrings("aa", "aa"));
        System.out.println(buddyStrings.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
