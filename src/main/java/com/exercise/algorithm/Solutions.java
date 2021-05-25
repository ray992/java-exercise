package com.exercise.algorithm;

/**
 * @ClassName Solutions
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/3/22 10:26 下午
 * @Version 1.0
 **/
public class Solutions {

    public static int hammingWeight(int n) {
        String s = String.valueOf(n);
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
