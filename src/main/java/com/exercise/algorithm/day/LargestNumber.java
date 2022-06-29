package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName LargestNumber
 * @Description 最大数
 * @Author yeqiang
 * @Date 2022/5/10 9:31 AM
 * @Version 1.0
 **/
public class LargestNumber {

    char[] numberOrderChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String largestNumber(int[] nums) {
        Map<Character, List<String>> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            char c = String.valueOf(nums[i]).charAt(0);
            List<String> numList = numMap.getOrDefault(c, new ArrayList<>());
            numList.add(String.valueOf(nums[i]));
            numMap.put(c, numList);
        }
        for (Map.Entry<Character, List<String>> map:numMap.entrySet()){
            List<String> numberList = map.getValue();
            Collections.sort(numberList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int n1 = o1.length();
                    int n2 = o2.length();
                    if (n1 == n2){
                        for (int i = 0;  i< n1; i++){
                            char c1 = o1.charAt(i);
                            char c2 = o2.charAt(i);
                            if (c1 != c2){
                                return c1 > c2 ? 1:-1; //升
                            }
                        }
                    }else {
                        int minN = Math.min(n1, n2);
                        for (int i = 0;  i< minN; i++){
                            char c1 = o1.charAt(i);
                            char c2 = o2.charAt(i);
                            if (c1 != c2){
                                return c1 > c2 ? 1:-1; //升
                            }
                        }
                        if (n1 < n2){
                            for (int t = minN, r = 0; t < n2; t++, r++){
                                char cc2 = o2.charAt(minN);
                                if (r > n1 -1){
                                    return -1;
                                }
                                char cc1 = o1.charAt(r);
                                if (cc1 == cc2){
                                    continue;
                                }
                                return cc1 > cc2 ? 1: -1;
                            }
                        }else {
                            for (int t = minN, r = 0; t < n1; t++, r++){
                                char cc1 = o1.charAt(minN);
                                if (r > n2 - 1){
                                    return 1;
                                }
                                char cc2 = o2.charAt(r);
                                if (cc1 == cc2){
                                    continue;
                                }
                                return cc1 > cc2 ? 1: -1;
                            }
                        }
                        return 1;
                    }
                    return 0;
                }
            });
            System.out.println(numberList);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numberOrderChar.length - 1; i >=0 ; i--){
            List<String> numList = numMap.get(numberOrderChar[i]);
            if (numList == null || numList.size() == 0){
                continue;
            }
            for (int r = numList.size() - 1; r >=0; r--){
                stringBuilder.append(numList.get(r));
            }
        }
        return stringBuilder.toString();
    }

    public String largestNumber2(int[] nums) {
        Map<Character, List<Integer>> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            char c = String.valueOf(nums[i]).charAt(0);
            List<Integer> numList = numMap.getOrDefault(c, new ArrayList<>());
            numList.add(nums[i]);
            numMap.put(c, numList);
        }
        for (Map.Entry<Character, List<Integer>> map:numMap.entrySet()) {
            List<Integer> numberList = map.getValue();
            Collections.sort(numberList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    long s1 = 10;
                    long s2 = 10;
                    while (s1 <= o1){
                        s1 *= 10;
                    }
                    while (s2 <= o2){
                        s2 *= 10;
                    }
                    return (int) (-s2*o1 - o2 + s1*o2 + o1);
                }
            });
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numberOrderChar.length - 1; i >=0 ; i--){
            List<Integer> numList = numMap.get(numberOrderChar[i]);
            if (numList == null || numList.size() == 0){
                continue;
            }
            if (numberOrderChar[i] == '0' && stringBuilder.toString().equals("")){
                stringBuilder.append('0');
                continue;
            }
            for (int r = 0; r < numList.size(); r++){
                stringBuilder.append(numList.get(r));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        //System.out.println(largestNumber.largestNumber2(new int[]{432, 43243}));
        //System.out.println(largestNumber.largestNumber2(new int[]{3,30,34,5,9, 563,56, 54}));
        //System.out.println(largestNumber.largestNumber2(new int[]{8308,8308,830}));
        //System.out.println(largestNumber.largestNumber2(new int[]{111311, 1113}));
        //System.out.println(largestNumber.largestNumber2(new int[]{0, 0, 0}));
        System.out.println(largestNumber.largestNumber2(new int[]{10, 2}));
        System.out.println(largestNumber.largestNumber2(new int[]{1,0,0}));

        //"830 8308 8308"
        //"8308 8308 830"
        // 8301 8301 830
        // 8308
        // 111311 1113
        // 1113 111311
    }
}
