package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName LargestInteger
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/10 10:31 AM
 * @Version 1.0
 **/
public class LargestInteger {

    public int largestInteger(int num) {
        String numString = String.valueOf(num);
        int length = numString.length();
        Integer[] perNumList = new Integer[length];
        int m = 0;
        while (length > 0){
            int cur = (num / (int)Math.pow(10, length -1));
            perNumList[m] = cur;
            num = num - cur * (int)Math.pow(10, length -1);
            length --;
            m++;
        }
        for (int i = 0; i < perNumList.length; i++){
            for (int j = i+1; j< perNumList.length; j++){
                int cur = perNumList[i];
                int compare = perNumList[j];
                if (compare > cur && (compare -cur) % 2 == 0){
                    int p = perNumList[i];
                    perNumList[i] = perNumList[j];
                    perNumList[j] = p;
                }
            }
        }
        int changeNum = 0;
        for (int i = 0; i < perNumList.length; i++){
            changeNum += Math.pow(10, perNumList.length - i -1)*perNumList[i];
        }
        return changeNum;
    }

    public static void main(String[] args) {
        LargestInteger largestInteger = new LargestInteger();
        System.out.println(largestInteger.largestInteger(3254));
        System.out.println(largestInteger.largestInteger(254));
        System.out.println(largestInteger.largestInteger(82504));
    }
}
