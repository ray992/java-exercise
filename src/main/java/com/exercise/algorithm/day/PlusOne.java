package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName PlusOne
 * @Description 加一
 * @Author yeqiang
 * @Date 2021/10/21 上午12:41
 * @Version 1.0
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        Deque<Integer> dataList = new LinkedList<>();
        int extra = 0;
        for (int i = n - 1; i >= 0; i--){
            if (i == n - 1){
                if (digits[i] + 1  == 10){
                    dataList.addLast(0);
                    extra = 1;
                }else {
                    dataList.addLast(digits[i] + 1);
                    extra = 0;
                }
            }else {
                if (digits[i] + extra == 10){
                    dataList.addLast(0);
                    extra = 1;
                }else {
                    dataList.addLast(digits[i] + extra);
                    extra = 0;
                }
            }
        }
        if (extra != 0){
            dataList.addLast(extra);
        }
        int[] res = new int[dataList.size()];
        int i = 0;
        while (!dataList.isEmpty()){
            res[i] = dataList.pollLast();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{8,9,9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9,9,9})));
    }
}
