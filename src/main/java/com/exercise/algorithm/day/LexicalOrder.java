package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LexicalOrder
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/18 9:28 AM
 * @Version 1.0
 **/
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> resList = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++){
            resList.add(number);
            if (number * 10 <= n){
                number*=10;
            }else {
                while (number % 10 == 9 || number + 1 > n){
                    number /= 10;
                }
                number++;
            }
        }
        return resList;
    }

    public List<Integer> lexicalOrder_2(int n) {
        List<Integer> resList = new ArrayList<>();
        String[] stringValue = new String[n];
        for (int i = 1; i <= n; i++){
            stringValue[i-1] = String.valueOf(i);
        }
        Arrays.sort(stringValue);
        for (int i = 0; i < stringValue.length; i++){
            resList.add(Integer.parseInt(stringValue[i]));
        }
        return resList;
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        System.out.println(lexicalOrder.lexicalOrder_2(192));
        System.out.println(1<<4);
    }
}
