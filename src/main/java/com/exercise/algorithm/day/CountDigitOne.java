package com.exercise.algorithm.day;

/**
 * @ClassName CountDigitOne
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/13 上午9:28
 * @Version 1.0
 **/
public class CountDigitOne {



    public int countDigitOne(int n) {
        //13 1 10 11 12
        int sum = 0;
        for (int i = 0; i <= n ; ++i){
            String valString = String.valueOf(i);
            int count =queryNum3(i, valString.length());
            System.out.println("i="+i+" count="+count);
            sum = sum + count;
        }
        return sum;

    }

    public int queryNum(String s){
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '1'){
                sum+=1;
            }
        }
        return sum;
    }

    public int queryNum2(String s){
        for (int i = 0; i <=9; i++){
            if (i == 1){
                continue;
            }
            s = s.replaceAll(i+"", "");
        }
        return s.length();
    }

    public int queryNum3(int n, int length){
        int sum = 0;
        while (length > 0){
            int high = (int)( n / (Math.pow(10, length-1)));
            if (high == 1){
                sum++;
            }
            n = n - high*(int)(Math.pow(10, length-1));
            length --;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        //System.out.println(countDigitOne.countDigitOne(0));
        System.out.println(countDigitOne.countDigitOne(200000000));
    }

}
