package com.exercise.random;

import java.security.SecureRandom;

/**
 * @ClassName SecureRandomDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/21 11:03 AM
 * @Version 1.0
 **/
public class SecureRandomDemo {

    public static void main(String[] args) {
        /*SecureRandom secureRandom = new SecureRandom();
        for (int i = 1; i < 1000; i++){
            System.out.println(secureRandom.nextDouble());
        }*/

        char c = 'a';
        int a = 1;
        a = a + c;
        System.out.println(a);
    }
}
