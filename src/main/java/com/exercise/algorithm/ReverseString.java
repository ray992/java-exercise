package com.exercise.algorithm;

/**
 * @ClassName ReverseString
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/3 下午4:50
 * @Version 1.0
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        char temp = '1';
        while (i <= j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        for (char cc:s){
            System.out.println(cc);
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'1','2','3'});
        reverseString.reverseString(new char[]{'3'});
    }
}
