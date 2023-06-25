package com.exercise.algorithm.offer;

import java.util.HashSet;
import java.util.Set;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String validString= "abcdefghijklmnopqrstuvwxyz0123456789";
        Set<Character> validCharacter = new HashSet<>();
        for (int i = 0; i < validString.length(); i++){
            validCharacter.add(validString.charAt(i));
        }
        int n = s.length();
        int left = 0 , right = n-1;
        while (left < right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!validCharacter.contains(c1)){
                left++;
                continue;
            }
            if (!validCharacter.contains(c2)){
                right--;
                continue;
            }
            if (c1 != c2){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("race a car"));
    }
}
