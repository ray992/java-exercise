package com.exercise.algorithm;

import java.util.Collections;

/**
 * @ClassName InsertBits
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/9/13 下午10:13
 * @Version 1.0
 **/
public class InsertBits {
    public int insertBits(int N, int M, int i, int j) {
        String s1 = Integer.toBinaryString(N);
        String s2 = Integer.toBinaryString(M);
        int n1 = s1.length();
        if (n1 < (j-i+1)){
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < j-i; k++){
                stringBuilder.append("0");
            }
            s1 = stringBuilder.toString()+s1;
        }
        int n2 = s2.length();
        if (j - i +1 > n2){
            s1 = s1.substring(n1-1-n2+1, n1-1-i).substring(n1-1-(j-i), n1-1-n2+1);
        }else {
            s1 = s1.substring(n1-1-i-(j-i), n1-1-i);
        }
        System.out.println(s1);
        return -1;
    }

    public static void main(String[] args) {
        InsertBits insertBits = new InsertBits();
        System.out.println(insertBits.insertBits(1024, 19, 2, 6));
    }
}
