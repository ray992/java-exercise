package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName Nums
 * @Description 数组子集
 * @Author yeqiang
 * @Date 2021/3/31 10:37 下午
 * @Version 1.0
 **/
public class Nums {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        String s = stringBuilder.toString();
        Set<String> subSet = new HashSet<>();
        int n = 0;
        while (n < nums.length+1){
            for (int i = 0; i < nums.length; i ++){
                int j = i + n;
                if (j > nums.length){
                    j = nums.length;
                }
                subSet.add(s.substring(i, j));
            }
            n++;
        }
        for (String string : subSet) {
            List<Integer> list = new ArrayList<>();
            if (string != null && !string.equals("")) {
                char[] chars = string.toCharArray();
                for (char c : chars) {
                    list.add(Integer.valueOf(new String(new char[]{c})));
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       System.out.println(subsetsWithDup(nums));
        System.out.println("123".substring(0,3));
    }
}
