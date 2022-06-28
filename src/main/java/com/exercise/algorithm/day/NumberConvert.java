package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName NumberConvert
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/2 9:42 下午
 * @Version 1.0
 **/
public class NumberConvert {

    public static int reverse(int x) {
        if(x == 0){
            return 0;
        }
        int topLimit = Integer.MAX_VALUE;
        int downLimit = Integer.MIN_VALUE;
        if (x <= downLimit || x >= topLimit){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        boolean negativeNumber = false;
        if(x < 0){
            negativeNumber = true;
            x = 0 - x;
        }
        String s = String.valueOf(x);
        int i = s.length()-1;
        while(true){
            int t = x / (int)Math.pow(10, i);
            x = x -  t*(int)Math.pow(10, i);
            if (i == 0 && x == 0){
                continue;
            }
            stack.add(t);
            int tempLength = String.valueOf(x).length();
            int exceed = i - tempLength ;
            if (exceed > 0){
                i = i - exceed;
                int j = 0;
                while (j< exceed){
                    stack.add(0);
                    j++;
                }
            }
            if(t == 0 || x == 0){
                break;
            }
            i--;
        }
        int j = stack.size() - 1;
        Double n = 0D;
        while (!stack.isEmpty()){
            int m = stack.pop();
            double factor = Math.pow(10,j);
            n = n + m*factor;
            j--;
        }
        if (negativeNumber){
            n = 0 - n;
        }
        if (n > topLimit || n < downLimit){
            return 0;
        }
        return n.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
