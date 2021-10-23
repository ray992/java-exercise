package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName LicenseKeyFormatting
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/4 下午5:08
 * @Version 1.0
 **/
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> characterList = new LinkedList<>();
        char[] chars = s.toUpperCase().toCharArray();
        int n = 0;
        for (char c:chars){
            if (c == '-'){
                continue;
            }
            characterList.addLast(c);
            n++;
        }
        if (characterList.size() == 0){
            return "";
        }
        int mod = n % k;
        StringBuilder formatSB = new StringBuilder();
        if (mod > 0){
            int j = 0;
            while (j < mod){
                formatSB.append(characterList.pollFirst());
                j++;
            }
            formatSB.append("-");
        }
        int t = 0;
        while (!characterList.isEmpty()){
            formatSB.append(characterList.pollFirst());
            t++;
            if (t == k){
                formatSB.append("-");
                t = 0;
            }
        }
        return formatSB.toString().substring(0, formatSB.lastIndexOf("-"));
    }

    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("---", 2));
    }
}
