package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName FindAnagrams1
 * @Description 找到字符串中所有字母异位词
 * @Author yeqiang
 * @Date 2022/7/7 6:52 PM
 * @Version 1.0
 **/
public class FindAnagrams1 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int sn = s.length();
        int pn = p.length();
        if (sn < pn){
            return resultList;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c:p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int kn = map.keySet().size();
        for (int i = 0; i < sn;){
            Map<Character, Integer> tempMap = new HashMap<>();
            int matchK = 0;
            boolean notExistStatus = false;
            int j = i;
            for (; j < sn; j++){
                char cc = s.charAt(j);
                if (!map.containsKey(cc)){
                    notExistStatus = true;
                    break;
                }
                int fre = tempMap.getOrDefault(cc, 0) + 1;
                if (fre == map.get(cc)){
                    matchK++;
                }
                if (matchK == kn){
                    resultList.add(i);
                    break;
                }
                if (fre > map.get(cc)){
                    break;
                }
                tempMap.put(cc, fre);
            }
            if (notExistStatus){
                i = j + 1;
            }else {
                i = i+1;
            }
        }
        return resultList;
    }

    public List<Integer> findAnagrams2(String s, String p){
        int sn = s.length();
        int pn = p.length();
        if (sn < pn){
            return new ArrayList<>();
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] need = new int[26];
        for (char c:p.toCharArray()){
            need[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int[] windows = new int[26];
        while (right < sn){
            windows[s.charAt(right) - 'a']++;
            if (right - left + 1 == pn){
                if (Arrays.equals(windows, need)){
                    resultList.add(left);
                }
                windows[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return resultList;
    }



    public static void main(String[] args) {
        FindAnagrams1 findAnagrams1 = new  FindAnagrams1();
        System.out.println(findAnagrams1.findAnagrams2("cbaebabacd", "abc"));
        System.out.println(findAnagrams1.findAnagrams2("abab", "ab"));
    }
}
